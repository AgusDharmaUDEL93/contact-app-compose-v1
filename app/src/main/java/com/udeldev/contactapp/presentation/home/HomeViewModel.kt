package com.udeldev.contactapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udeldev.contactapp.domain.model.InvalidFriendException
import com.udeldev.contactapp.domain.use_cases.FriendUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val friendUseCases: FriendUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var getFriendJob: Job? = null

    init {
        getFriend()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.AddFriend -> {
                viewModelScope.launch {
                    try {
                        friendUseCases.addFriendUseCase(
                            event.friend
                        )
                    } catch (_: InvalidFriendException) {

                    }
                }
            }

            is HomeEvent.DeleteFriend -> {
                viewModelScope.launch {
                    friendUseCases.deleteFriendUseCase(event.friend)
                }
            }

            is HomeEvent.EnteredName -> {
                _state.value = _state.value.copy(
                    enteredName = event.name
                )
            }
        }
    }

    private fun getFriend() {
        getFriendJob?.cancel()
        getFriendJob = friendUseCases.getFriendsUseCase()
            .onEach { friends ->
                _state.value = _state.value.copy(
                    friends,
                )
            }.launchIn(viewModelScope)
    }



}
sealed class UiEvent {
    data class ShowSnackbar(val message: String): UiEvent()
    object SaveNote: UiEvent()
}
