package com.kyawlinnthant.betr.presentation.updates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawlinnthant.betr.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    private val vmState = MutableStateFlow(UpdateViewModelState())
    val apps = vmState.map(UpdateViewModelState::getUpdatedApps).stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = vmState.value.getUpdatedApps()
    )
    val enabled = vmState.map(UpdateViewModelState::getEnabled).stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = vmState.value.getEnabled()
    )

    init {
        getApps()
        getEnabled()
    }

    private fun getApps() {
        viewModelScope.launch {
            repo.getDummyApps().also {
                vmState.update { state ->
                    state.copy(
                        apps = it
                    )
                }
            }
        }
    }

    private fun getEnabled() {
        viewModelScope.launch {
            repo.getEnabled().also {
                vmState.update { state ->
                    state.copy(
                        isEnabled = it
                    )
                }
            }
        }
    }
}