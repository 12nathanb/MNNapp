package com.example.japanesestudy2.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.japanesestudy2.R
import com.example.japanesestudy2.di.TtsProvider

class MNNItemAdapter(private val dataSet: List<MNNItems>, private val tts: TtsProvider) :
    RecyclerView.Adapter<MNNItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val kanjiText: TextView
        val hiraganaText: TextView
        val englishText: TextView
        val ttsButton: AppCompatImageButton
        init {
            // Define click listener for the ViewHolder's View
            kanjiText = view.findViewById(R.id.kanji)
            hiraganaText = view.findViewById(R.id.hiragana)
            englishText = view.findViewById(R.id.english)
            ttsButton = view.findViewById(R.id.tts)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.vocab_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if (dataSet[position].kanji.replace(" ", "") != dataSet[position].hiragana.replace(" ", ""))
        {
            viewHolder.kanjiText.text = dataSet[position].kanji.replace(" ", "")
        } else {
            viewHolder.kanjiText.visibility = View.GONE
        }

        viewHolder.hiraganaText.text = dataSet[position].hiragana.replace(" ", "")
        viewHolder.englishText.text = dataSet[position].english.trim()

        viewHolder.ttsButton.setOnClickListener {
            tts.speakOut(viewHolder.hiraganaText.text.toString())
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}