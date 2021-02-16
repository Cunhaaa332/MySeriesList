package com.cunha.myserieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cunha.myserieslist.database.AppDatabase
import com.cunha.myserieslist.model.Episodio
import com.cunha.myserieslist.model.Serie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appDatabase = AppDatabase.getInstance(this)
        val serieDao = appDatabase.serieDao()
        val episodioDao = appDatabase.episodioDao()
        /*GlobalScope.launch {
            serieDao.insert(Serie("Breaking Bad", "01/01/2001", "AAAA", "10", "aaaaa"))
            episodioDao.insert(Episodio("Pilot",1,"O primeiro ep.","10",1))
            episodioDao.insert(Episodio("Cat´s in the Bag",2,"O segundo ep.","10",1))
            Log.i("Serie Lida: ", serieDao.read(1).toString())
        }*/


    }
}