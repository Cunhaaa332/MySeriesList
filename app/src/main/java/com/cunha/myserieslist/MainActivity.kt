package com.cunha.myserieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = File(filesDir, "teste")

        if(!file.exists())
            file.createNewFile()

        if(file.canRead())
            Log.i("Arquivo", "Leitura permitida.")

        if(file.canWrite())
            Log.i("Arquivo", "Escrita Permitida.")
    }
}