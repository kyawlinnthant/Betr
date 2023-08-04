package com.kyawlinnthant.betr.presentation.updates

import com.kyawlinnthant.betr.data.UpdatedApp

data class UpdateViewModelState(
    val apps: List<UpdatedApp> = emptyList(),
    val isEnabled: Boolean = false
) {
    fun getUpdatedApps() = apps
    fun getEnabled() = isEnabled
}
