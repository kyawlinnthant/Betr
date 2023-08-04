package com.kyawlinnthant.betr.data

import kotlinx.coroutines.flow.Flow

interface SettingDataStore {
    suspend fun putEnabled(value: Boolean)
    suspend fun pullEnabled() : Flow<Boolean>
    suspend fun clear()
}