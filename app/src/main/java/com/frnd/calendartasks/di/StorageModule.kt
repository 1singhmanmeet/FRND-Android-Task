package com.frnd.calendartasks.di

import android.content.Context
import androidx.room.Room
import com.frnd.calendartasks.data.local.AppDatabase
import com.frnd.calendartasks.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    @Singleton
    fun providesRoomDb(@ApplicationContext context: Context)=
        Room.databaseBuilder(context,
            AppDatabase::class.java, "app_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesTaskDao(appDatabase: AppDatabase)=
        appDatabase.taskDao()

    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext context:Context)=
        context.getSharedPreferences(Constants.TASKS_PREFS,Context.MODE_PRIVATE)

}