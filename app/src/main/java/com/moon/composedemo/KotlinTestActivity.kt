package com.moon.composedemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import com.moon.composedemo.R
import com.moon.composedemo.coroutine.CoroutineSene

class KotlinTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_layout)
        val btn = findViewById<Button>(R.id.test_button)
        btn.setOnClickListener{
            CoroutineSene.startScene1()
        }
    }
}