package com.udeldev.contactapp.domain.use_cases

import com.udeldev.contactapp.domain.model.Friend
import com.udeldev.contactapp.domain.repository.FriendRepository
import kotlinx.coroutines.flow.Flow

class GetFriendsUseCase (
    private val repository: FriendRepository
) {
    operator fun invoke () : Flow<List<Friend>>{
        return repository.getFriends()
    }
}