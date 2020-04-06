package com.example.ohsystudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = NaverAPI.create()

        api.getSearchMovies(CLIENT_ID, CLIENT_SECRET, "매드맥스", 10, 1)
            .enqueue(object : Callback<MovieList> {
                override fun onResponse(
                    call: Call<MovieList>,
                    response: Response<MovieList>
                ) {
                    // 성공
                    Log.d(TAG, "성공 : ${response.raw()}")
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    // 실패
                    Log.d(TAG, "실패 : $t")
                }
            })

    }
}
