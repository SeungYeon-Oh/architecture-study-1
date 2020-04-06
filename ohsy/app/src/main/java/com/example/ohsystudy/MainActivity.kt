package com.example.ohsystudy

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = NaverAPI.create()

        //레이아웃매니저 설정
        movieRV.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        movieRV.setHasFixedSize(true)

        searchBtn.setOnClickListener({
            var movieName = searchInput.text.toString()
            Log.d(TAG, "searchInput : $movieName")
            api.getSearchMovies(CLIENT_ID, CLIENT_SECRET, movieName, 10, 1)
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


        })


    }
}
