package com.udeldev.contactapp.domain.use_cases

data class FriendUseCases (
    val getFriendsUseCase: GetFriendsUseCase,
    val addFriendUseCase: AddFriendUseCase,
    val deleteFriendUseCase: DeleteFriendUseCase,
)