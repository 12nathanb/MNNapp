package com.example.japanesestudy2.ui.vocab

import androidx.lifecycle.ViewModel
import com.example.japanesestudy2.data.MNNAdj
import com.example.japanesestudy2.data.MNNVocab
import com.example.japanesestudy2.data.MNNItemAdapter
import com.example.japanesestudy2.data.MNNItems
import com.example.japanesestudy2.data.MNNVerb
import com.example.japanesestudy2.di.DatabaseModule
import com.example.japanesestudy2.di.TtsProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VocabViewModel @Inject constructor(
    private val database: DatabaseModule,
    private val tts: TtsProvider
) : ViewModel() {
    var vocabDatabase = database.MMNDatabase()

    var vocabList = mutableListOf<MNNItems>()
    var adjList = mutableListOf<MNNItems>()
    var verbList = mutableListOf<MNNItems>()

    var allList = mutableListOf<MNNItems>()

    private var vocabListSearch = mutableListOf<MNNItems>()
    var adapter: MNNItemAdapter = MNNItemAdapter(vocabListSearch, tts)

    fun setAdapterData(data: List<MNNItems>) {
        vocabListSearch.clear()
        vocabListSearch.addAll(data)
    }

    fun searchList(data: String) {
        if (data.isNotBlank()) {
            setAdapterData(allList.filter {
                it.english.lowercase().contains(data) || it.hiragana.contains(data) || it.kanji.contains(
                    data
                )
            }.sortedBy { it.english })
        } else {
            setAdapterData(allList.sortedBy { it.english })
        }
    }
}