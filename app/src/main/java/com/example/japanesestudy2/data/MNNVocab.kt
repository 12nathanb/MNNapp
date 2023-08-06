package com.example.japanesestudy2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MNNItems(
    val kanji: String,
    val hiragana: String,
    val english: String,
    val lesson: Int
)

@Entity(tableName = "MNNvocab")
data class MNNVocab(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "KANJI") val kanji: String,
    @ColumnInfo(name = "HIRAGANA") val hiragana: String,
    @ColumnInfo(name = "ENGLISH") val english: String,
    @ColumnInfo(name = "LESSON") val lesson: Int
) {
    fun toMnnVItem(): MNNItems =
        MNNItems(
            kanji = this.kanji,
            hiragana = this.hiragana,
            english = this.english,
            lesson = this.lesson
        )
}

@Entity(tableName = "MNNadjs")
data class MNNAdj(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "KANJI") val kanji: String,
    @ColumnInfo(name = "HIRAGANA") val hiragana: String,
    @ColumnInfo(name = "ENGLISH") val english: String,
    @ColumnInfo(name = "LESSON") val lesson: Int
) {
    fun toMnnVItem(): MNNItems =
        MNNItems(
            kanji = this.kanji,
            hiragana = this.hiragana,
            english = this.english,
            lesson = this.lesson
        )
}

@Entity(tableName = "MNNverbs")
data class MNNVerb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "KANJI") val kanji: String,
    @ColumnInfo(name = "HIRAGANA") val hiragana: String,
    @ColumnInfo(name = "ENGLISH") val english: String,
    @ColumnInfo(name = "LESSON") val lesson: Int
) {
    fun toMnnVItem(): MNNItems =
        MNNItems(
            kanji = this.kanji,
            hiragana = this.hiragana,
            english = this.english,
            lesson = this.lesson
        )
}