package com.cunha.myserieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cunha.myserieslist.database.AppDatabase
import com.cunha.myserieslist.model.Serie
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}