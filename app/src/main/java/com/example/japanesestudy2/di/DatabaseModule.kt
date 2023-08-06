package com.example.japanesestudy2.di

import android.content.Context
import androidx.room.Room
import com.example.japanesestudy2.data.MNNItemDatabase
import com.google.android.datatransport.runtime.dagger.Module
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Module
@Singleton
class DatabaseModule @Inject constructor(
    @ApplicationContext val context: Context
){
    fun MMNDatabase() = Room.databaseBuilder(
        context,
        MNNItemDatabase::class.java,
        "vocab_database4"
    ).createFromAsset("database/data.db")
        .fallbackToDestructiveMigration()
        .build()

}