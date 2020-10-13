package com.myanmarit.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myanmarit.database.entity.Word

@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word_id ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)
    //abstract fun getSearchWords(word: String): LiveData<List<Word>>

    @Query("SELECT * from word_table WHERE word_id LIKE :word ORDER BY word_id ASC")
    fun getSearchWords(word: String): LiveData<List<Word>>

    @Query("DELETE FROM word_table where word_id = :word_id")
    suspend fun delete(word_id: String)

    @Query("UPDATE word_table SET word_id = :update_word WHERE word_id = :word_id")
    suspend fun update(word_id: String,update_word:String)
}
