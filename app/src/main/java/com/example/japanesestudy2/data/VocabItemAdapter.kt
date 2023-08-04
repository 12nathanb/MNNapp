package com.example.japanesestudy2.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.japanesestudy2.R

class VocabItemAdapter(private val dataSet: List<MNNVocab>) :
    RecyclerView.Adapter<VocabItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val kanjiText: TextView
        val hiraganaText: TextView
        val englishText: TextView

        init {
            // Define click listener for the ViewHolder's View
            kanjiText = view.findViewById(R.id.kanji)
            hiraganaText = view.findViewById(R.id.hiragana)
            englishText = view.findViewById(R.id.english)

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
        viewHolder.kanjiText.text = dataSet[position].kanji.replace(" ", "")
        viewHolder.hiraganaText.text = dataSet[position].hiragana.replace(" ", "")
        viewHolder.englishText.text = dataSet[position].english.trim()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}