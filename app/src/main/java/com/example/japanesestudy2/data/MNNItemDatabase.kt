package com.example.japanesestudy2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MNNVocab::class, MNNVerb::class, MNNAdj::class], version = 3)
abstract class MNNItemDatabase : RoomDatabase() {
    abstract fun mnnVocabDao(): MNNItemDao
}