package com.example.japanesestudy2.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "MNNvocab")
data class MNNVocab(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "KANJI") val kanji: String,
    @ColumnInfo(name = "HIRAGANA") val hiragana: String,
    @ColumnInfo(name = "ENGLISH") val english: String,
    @ColumnInfo(name = "LESSON") val lesson: Int
)