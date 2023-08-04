package com.kyawlinnthant.betr.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.kyawlinnthant.betr.di.DispatchersModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class SettingDataStoreImpl @Inject constructor(
    private val datastore: DataStore<Preferences>,
    @DispatchersModule.IO private val io: CoroutineDispatcher
) : SettingDataStore {

    companion object {
        const val PREF_NAME = "setting.ds.pref"
        val ENABLED = booleanPreferencesKey("com.pref.enabled")
    }

    override suspend fun putEnabled(value: Boolean) {
        withContext(io) {
            datastore.edit {
                it[ENABLED] = value
            }
        }
    }

    override suspend fun pullEnabled(): Flow<Boolean> {
        return datastore.data
            .catch {
                if (it is IOException) emit(emptyPreferences()) else throw it
            }.map {
                it[ENABLED] ?: false
            }.flowOn(io)
    }

    override suspend fun clear() {
        withContext(io) {
            datastore.edit { it.clear() }
        }
    }
}