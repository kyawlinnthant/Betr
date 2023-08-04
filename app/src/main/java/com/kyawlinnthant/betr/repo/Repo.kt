package com.kyawlinnthant.betr.repo

import com.kyawlinnthant.betr.data.UpdatedApp
import kotlinx.coroutines.flow.Flow

interface Repo {
    suspend fun pullEnabled() : Flow<Boolean>
    suspend fun getEnabled() : Boolean
    suspend fun setEnabled(isEnabled: Boolean)
    suspend fun getDummyApps() : List<UpdatedApp>
}