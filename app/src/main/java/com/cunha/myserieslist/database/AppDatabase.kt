package com.cunha.myserieslist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie

abstract class AppDatabase : RoomDatabase() {
    //abstract fun serieDao(): SerieDao
    //abstract fun episodioDao(): EpisodioDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase{
            if (instance == null)
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "database.db").build()
            return instance as AppDatabase
        }
    }
}