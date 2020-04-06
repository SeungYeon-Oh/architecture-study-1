package com.example.ohsystudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    val BASE_URL_NAVER_API = "https://openapi.naver.com/"
    val CLIENT_ID = getString(R.string.CLIENT_ID)
    val CLIENT_SECRET = getString(R.string.CLIENT_SECRET)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
