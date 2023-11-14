package com.udeldev.contactapp.data.repository

import com.udeldev.contactapp.data.sources.FriendDao
import com.udeldev.contactapp.domain.model.Friend
import com.udeldev.contactapp.domain.repository.FriendRepository
import kotlinx.coroutines.flow.Flow

class FriendRepositoryImpl (
    private val dao: FriendDao
)  : FriendRepository{
    override fun getFriends(): Flow<List<Friend>> {
        return dao.getFriends()
    }

    override suspend fun insertFriend(friend: Friend) {
        dao.insertFriend(friend)
    }

    override suspend fun deleteFriend(friend: Friend) {
        dao.deleteFriend(friend)
    }
}