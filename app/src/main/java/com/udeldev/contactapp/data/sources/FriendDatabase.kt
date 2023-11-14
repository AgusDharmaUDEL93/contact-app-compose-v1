package com.udeldev.contactapp.data.sources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udeldev.contactapp.domain.model.Friend


@Database(
    version = 1,
    entities = [Friend::class]
)
abstract class FriendDatabase : RoomDatabase() {
    abstract val friendDao : FriendDao

    companion object{
        const val DATABASE_NAME = "friend_db"
    }
}