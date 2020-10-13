package com.myanmarit.database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myanmarit.database.R
import com.myanmarit.database.entity.Word
import kotlinx.android.synthetic.main.fragment_word.view.*
import kotlinx.android.synthetic.main.item_show_word.view.*

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    var clickListener: ClickListener? = null
    private var wordList: List<Word> = ArrayList()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        lateinit var word: Word
        fun bind(word: Word) {
            this.word = word
            itemView.txt_item.text = word.word
        }

        override fun onClick(v: View?) {
            clickListener?.onClick(word)
        }

    }

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_show_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position])
    }

    override fun getItemCount(): Int = wordList.size
    fun setWord(wordList: List<Word>) {
        this.wordList = wordList
        notifyDataSetChanged()
    }


    interface ClickListener {
         fun onClick(word: Word) {

        }
    }
}

