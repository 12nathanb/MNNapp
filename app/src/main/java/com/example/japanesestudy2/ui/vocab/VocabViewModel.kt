package com.example.japanesestudy2.ui.vocab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.japanesestudy2.data.MNNVocab
import com.example.japanesestudy2.data.VocabItemAdapter

class VocabViewModel : ViewModel() {
    var vocabList = mutableListOf<MNNVocab>()
    var adapter: VocabItemAdapter

    init {
        adapter = VocabItemAdapter(vocabList)
    }
}