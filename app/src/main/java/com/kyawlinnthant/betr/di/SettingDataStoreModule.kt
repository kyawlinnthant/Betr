package com.kyawlinnthant.betr.di

import android.content.Context
import androidx.core.view.WindowInsetsAnimationCompat.Callback.DispatchMode
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.kyawlinnthant.betr.data.SettingDataStore
import com.kyawlinnthant.betr.data.SettingDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SettingDataStoreModule {
    @Provides
    @Singleton
    fun providePref(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(
                    name = SettingDataStoreImpl.PREF_NAME
                )
            }
        )
    }
    @Provides
    @Singleton
    fun provideDataStore(
        ds : DataStore<Preferences>,
        @DispatchersModule.IO IO : CoroutineDispatcher
    ) : SettingDataStore {
        return SettingDataStoreImpl(
            datastore = ds,
            io = IO
        )
    }
}