package com.udeldev.contactapp.domain.repository

import com.udeldev.contactapp.domain.model.Friend
import kotlinx.coroutines.flow.Flow

interface FriendRepository {

    fun getFriends () : Flow<List<Friend>>

    suspend fun insertFriend(friend: Friend)

    suspend fun deleteFriend (friend: Friend)
}