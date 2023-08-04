package com.kyawlinnthant.betr.repo

import com.kyawlinnthant.betr.R
import com.kyawlinnthant.betr.data.SettingDataStore
import com.kyawlinnthant.betr.data.UpdatedApp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val datastore: SettingDataStore
) : Repo {
    override suspend fun pullEnabled(): Flow<Boolean> {
        return datastore.pullEnabled()
    }

    override suspend fun getEnabled(): Boolean {
        return datastore.pullEnabled().firstOrNull() ?: false
    }

    override suspend fun setEnabled(isEnabled: Boolean) {
        datastore.putEnabled(isEnabled)
    }

    override suspend fun getDummyApps(): List<UpdatedApp> {
        return getDummies()
    }

    // access R in data layer is bad. But this is for task only.
    private fun getDummies(): List<UpdatedApp> {
        val facebook = UpdatedApp(
            icon = R.drawable.facebook,
            name = R.string.facebook
        )
        val messenger = UpdatedApp(
            icon = R.drawable.messenger,
            name = R.string.messenger
        )
        val youtube = UpdatedApp(
            icon = R.drawable.youtube,
            name = R.string.youtube
        )
        val chrome = UpdatedApp(
            icon = R.drawable.chrome,
            name = R.string.chrome
        )
        return listOf(
            facebook,
            messenger,
            youtube,
            chrome
        )
    }
}