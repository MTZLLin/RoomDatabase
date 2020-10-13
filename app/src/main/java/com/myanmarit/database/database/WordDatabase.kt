package com.myanmarit.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myanmarit.database.dao.WordDao
import com.myanmarit.database.entity.Word
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Word::class),version = 2)
abstract class WordDatabase: RoomDatabase(){
    abstract fun wordDao(): WordDao

    companion object{
        private var INSTANCE: WordDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope):WordDatabase
        {
            val tempInstant = INSTANCE
            if(tempInstant != null){
                return tempInstant
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}