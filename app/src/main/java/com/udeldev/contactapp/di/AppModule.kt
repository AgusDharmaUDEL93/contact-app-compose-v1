package com.udeldev.contactapp.di

import android.app.Application
import androidx.room.Room
import com.udeldev.contactapp.data.repository.FriendRepositoryImpl
import com.udeldev.contactapp.data.sources.FriendDatabase
import com.udeldev.contactapp.domain.repository.FriendRepository
import com.udeldev.contactapp.domain.use_cases.AddFriendUseCase
import com.udeldev.contactapp.domain.use_cases.DeleteFriendUseCase
import com.udeldev.contactapp.domain.use_cases.FriendUseCases
import com.udeldev.contactapp.domain.use_cases.GetFriendsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFriendDatabase(app : Application) : FriendDatabase{
        return Room.databaseBuilder(
            app,
            FriendDatabase::class.java,
            FriendDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesFriendRepository (db : FriendDatabase) : FriendRepository{
        return FriendRepositoryImpl(db.friendDao)
    }

    @Provides
    @Singleton
    fun providesFriendUseCases (repository: FriendRepository) : FriendUseCases{
        return FriendUseCases(
            getFriendsUseCase = GetFriendsUseCase(repository),
            addFriendUseCase = AddFriendUseCase(repository),
            deleteFriendUseCase = DeleteFriendUseCase(repository)
        )
    }

}