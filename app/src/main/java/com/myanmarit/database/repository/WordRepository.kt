package com.myanmarit.database.repository

import androidx.lifecycle.LiveData
import com.myanmarit.database.dao.WordDao
import com.myanmarit.database.entity.Word

class WordRepository (private val wordDao: WordDao){
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
    fun searchWord(word: String) : LiveData<List<Word>>{
        return wordDao.getSearchWords(word)
    }
    suspend fun deleteWord(word: String){
        wordDao.delete(word)
    }
    suspend fun updateWord(word: String,update_word:String){
        wordDao.update(word,update_word)
    }
}