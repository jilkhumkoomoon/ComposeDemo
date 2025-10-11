package com.moon.composedemo.coroutine

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object CoroutineSene {

    private val TAG: String  = "CoroutineSene"

    fun startScene1() {
        GlobalScope.launch(Dispatchers.Main) {
            Log.e(TAG,"Coroutine is running")
            val result1:String = request1()
            val result2:String = request2(result1)
            val result3:String = request3(result2)

            updateUI(result3)
        }
        Log.e(TAG, "coroutine has launched" )
    }

    private fun updateUI(result: String) {
        Log.e(TAG, "update ui work on ${Thread.currentThread().name}")
        Log.e(TAG, "paramter: $result")
    }

    suspend fun request1() : String {
        delay(2 * 1000)
        Log.e(TAG, "request work on ${Thread.currentThread().name}")
        return "result from request1"
    }

    suspend fun request2(result:String) : String {
        delay(2 * 1000)
        Log.e(TAG, "request work on ${Thread.currentThread().name}")
        return "result from request2"
    }

    suspend fun request3(result: String) : String {
        delay(2 * 1000)
        Log.e(TAG, "request work on ${Thread.currentThread().name}")
        return "result from request3"
    }

}