package com.udeldev.contactapp.presentation.home

import com.udeldev.contactapp.domain.model.Friend

sealed class HomeEvent {
    data class AddFriend( val friend: Friend) : HomeEvent()
    data class DeleteFriend (val friend: Friend) : HomeEvent()
    data class EnteredName (val name : String ) : HomeEvent()
}