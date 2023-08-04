package com.example.japanesestudy2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MNNVocab::class], version = 2)
abstract class MNNVocabDatabase : RoomDatabase() {
    abstract fun mnnVocabDao(): MNNVocabDao
}