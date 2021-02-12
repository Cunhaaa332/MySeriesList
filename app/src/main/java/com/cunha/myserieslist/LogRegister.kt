package com.cunha.myserieslist

import android.content.Context

class LogRegister(
        private val context: Context
        ){

    private val nomeArq = "logRegister.log"

    fun escreveLog (msg: String){
        val fileOS = context.openFileOutput(nomeArq, Context.MODE_APPEND)
        fileOS.write(msg.toByteArray())
        fileOS.close()
    }

    companion object {
        private var instance: LogRegister? = null
        fun getInstance(context: Context): LogRegister{
            if (instance == null)
                instance = LogRegister(context)
            return instance as LogRegister
        }
    }

}