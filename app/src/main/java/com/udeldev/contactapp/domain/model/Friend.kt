package com.udeldev.contactapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Friend(

    @PrimaryKey
    val id : Int? = null,
    val name : String,
)

class InvalidFriendException (message : String) : Exception(message)