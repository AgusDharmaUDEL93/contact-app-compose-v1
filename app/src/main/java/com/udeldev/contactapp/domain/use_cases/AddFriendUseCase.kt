package com.udeldev.contactapp.domain.use_cases

import androidx.compose.ui.res.stringResource
import com.udeldev.contactapp.R
import com.udeldev.contactapp.domain.model.Friend
import com.udeldev.contactapp.domain.model.InvalidFriendException
import com.udeldev.contactapp.domain.repository.FriendRepository

class AddFriendUseCase (
    private val repository: FriendRepository
) {
    @Throws(InvalidFriendException::class)
    suspend operator fun  invoke (friend: Friend){
        if (friend.name.isBlank()){
            throw InvalidFriendException("The name of the friend can't be empty.")
        }
        repository.insertFriend(friend)
    }
}