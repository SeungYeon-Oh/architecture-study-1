package com.example.ohsystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val CLIENT_ID = getString(R.string.CLIENT_ID)
    val CLIENT_SECRET = getString(R.string.CLIENT_SECRET)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
