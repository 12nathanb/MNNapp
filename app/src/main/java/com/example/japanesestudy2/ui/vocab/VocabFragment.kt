package com.example.japanesestudy2.ui.vocab

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.japanesestudy2.data.MNNVocabDatabase
import com.example.japanesestudy2.data.VocabItemAdapter
import com.example.japanesestudy2.databinding.FragmentVocabBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VocabFragment : Fragment() {

    private var _binding: FragmentVocabBinding? = null
    lateinit var viewModel: VocabViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(VocabViewModel::class.java)

        _binding = FragmentVocabBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vocabList.layoutManager = LinearLayoutManager(requireContext())
        binding.vocabList.adapter = viewModel.adapter

        var db = Room.databaseBuilder(
            requireContext(),
            MNNVocabDatabase::class.java,
            "vocab_database3"
        ).createFromAsset("database/vocab.db").build()

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.vocabList.clear()
            viewModel.vocabList.addAll( db.mnnVocabDao().readAll())

            withContext(Dispatchers.Main) {
                Log.println(Log.DEBUG, "db", viewModel.vocabList.size.toString())
                viewModel.adapter.notifyDataSetChanged()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}