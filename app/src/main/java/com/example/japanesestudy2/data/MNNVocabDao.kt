package com.example.japanesestudy2.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MNNVocabDao {
    @Query("SELECT * FROM MNNvocab")
    fun readAll(): List<MNNVocab>
}