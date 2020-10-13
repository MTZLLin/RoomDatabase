package com.myanmarit.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.myanmarit.database.database.WordDatabase
import com.myanmarit.database.entity.Word
import com.myanmarit.database.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewmodel(application: Application) : AndroidViewModel(application) {
    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        var wordDao = WordDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
    fun getSearchWord(word: String):LiveData<List<Word>>{
        return repository.searchWord(word)
    }
    fun deleteWord(word: String) = viewModelScope.launch{
        repository.deleteWord(word)
    }
    fun updateWord(word: String,update_word:String) = viewModelScope.launch{
        repository.updateWord(word,update_word)
    }
}