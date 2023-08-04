package com.kyawlinnthant.betr.presentation.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawlinnthant.betr.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    private val vmState = MutableStateFlow(SettingViewModelState())
    val enabled = vmState.map(SettingViewModelState::getUpdateEnabled).stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = vmState.value.getUpdateEnabled()
    )
    init {
        getEnabled()
    }

    private fun getEnabled() {
        viewModelScope.launch {
            repo.pullEnabled().collect {
                vmState.update { state ->
                    state.copy(
                        enabled = it
                    )
                }
            }
        }
    }

    fun setEnabled(value: Boolean) {
        viewModelScope.launch {
            repo.setEnabled(value)
        }
    }

}