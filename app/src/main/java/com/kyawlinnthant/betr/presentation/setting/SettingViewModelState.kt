package com.kyawlinnthant.betr.presentation.setting

data class SettingViewModelState(
    val enabled : Boolean = false
){
    fun getUpdateEnabled() = enabled
}
