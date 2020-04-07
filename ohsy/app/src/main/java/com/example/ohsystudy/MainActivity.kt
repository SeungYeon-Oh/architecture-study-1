package com.example.ohsystudy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
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

//                        val body = response.body().toString()
                        val body = response.body()
                        Log.d(TAG, "body : ${body} ")
//                        Log.d(TAG, "body : ${response.body()?.items.toString()} ")

                        val gson = GsonBuilder().create()

                        //응답온 데이터를 먼저 json으로 바꿔줘야함
                        //이걸 해야 com.google.gson.JsonSyntaxException: java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
                        //이 에러가 안 뜸!!
                        val jsonMovieList = gson.toJson(body)

                        //json으로 바꾼 데이터를 gson으로 파싱함.
                        val movieList = gson.fromJson(jsonMovieList, MovieList::class.java)

                        runOnUiThread {
                            movieRV.adapter = MovieRVAdapter(movieList)
                            searchInput.setText("")
                        }

                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        // 실패
                        Log.d(TAG, "실패 : $t")
                    }
                })


        })

    }


}
