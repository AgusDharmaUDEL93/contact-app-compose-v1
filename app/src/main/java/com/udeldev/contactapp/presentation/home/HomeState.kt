package com.udeldev.contactapp.presentation.home

import com.udeldev.contactapp.domain.model.Friend

data class HomeState (
    val friend : List<Friend> = emptyList(),
    val enteredName : String = ""
)