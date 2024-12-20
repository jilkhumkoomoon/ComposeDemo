package com.moon.composedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class NormalMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_normal)
        Log.e("fragmentlife", "MainActivity onCreate: " )
    }

}