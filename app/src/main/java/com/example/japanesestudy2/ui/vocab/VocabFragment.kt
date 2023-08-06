package com.example.japanesestudy2.ui.vocab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.japanesestudy2.data.MNNItems
import com.example.japanesestudy2.data.MNNVocab
import com.example.japanesestudy2.databinding.FragmentVocabBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class VocabFragment : Fragment() {

    private var _binding: FragmentVocabBinding? = null
    private val viewModel by viewModels<VocabViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVocabBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vocabList.layoutManager = LinearLayoutManager(requireContext())
        binding.vocabList.adapter = viewModel.adapter

        binding.vocabSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchList(newText)
                viewModel.adapter.notifyDataSetChanged()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean = false
        })



        CoroutineScope(Dispatchers.IO).launch {
            viewModel.vocabList.addAll(viewModel.vocabDatabase.mnnVocabDao().readAllVocab().map { MNNItems(it.kanji, it.hiragana, it.english, it.lesson) })
            viewModel.adjList.addAll(viewModel.vocabDatabase.mnnVocabDao().readAllAdjs().map { MNNItems(it.kanji, it.hiragana, it.english, it.lesson) })
            viewModel.verbList.addAll(viewModel.vocabDatabase.mnnVocabDao().readAllVerb().map { MNNItems(it.kanji, it.hiragana, it.english, it.lesson) })

            viewModel.allList.addAll(viewModel.vocabList)
            viewModel.allList.addAll(viewModel.adjList)
            viewModel.allList.addAll(viewModel.verbList)

            viewModel.setAdapterData(viewModel.vocabList.sortedBy { it.english })

            withContext(Dispatchers.Main) {
                viewModel.adapter.notifyDataSetChanged()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}