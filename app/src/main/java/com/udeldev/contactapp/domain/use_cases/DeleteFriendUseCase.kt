package com.udeldev.contactapp.domain.use_cases

import com.udeldev.contactapp.domain.model.Friend
import com.udeldev.contactapp.domain.repository.FriendRepository

class DeleteFriendUseCase(
    private val repository: FriendRepository
) {

    suspend operator fun invoke(friend: Friend) {
        repository.deleteFriend(friend)
    }
}