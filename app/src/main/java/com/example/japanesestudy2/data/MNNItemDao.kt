package com.example.japanesestudy2.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MNNItemDao {
    @Query("SELECT * FROM MNNvocab")
    fun readAllVocab(): List<MNNVocab>

    @Query("SELECT * FROM MNNadjs")
    fun readAllAdjs() : List<MNNAdj>

    @Query("SELECT * FROM MNNverbs")
    fun readAllVerb() : List<MNNVerb>

}