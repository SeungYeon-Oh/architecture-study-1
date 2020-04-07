package com.example.ohsystudy

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_movie_rv.view.*

class MovieRVAdapter(val movieList: MovieList): RecyclerView.Adapter<MovieRVAdapter.ViewHolder>() {

    //아이템의 갯수
    override fun getItemCount(): Int {
        return movieList.items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_rv, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MovieRVAdapter.ViewHolder, position: Int) {
        holder.bindItems(movieList.items.get(position))
    }


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bindItems(data : Movie){
            //
            Glide.with(view.context).load(data.image)
                .apply(RequestOptions().override(300, 450))
                .apply(RequestOptions.centerCropTransform())
                .into(view.movieImg)
            itemView.movieTitle.text = data.title
            itemView.movieInfo.text = "출연 ${data.actor}"
//            itemView.textView_director.text = "감독 ${data.director}"

            //클릭시 웹사이트 연결
            itemView.movieCard.setOnClickListener({
                val webpage = Uri.parse("${data.link}")
                val webIntent = Intent(Intent.ACTION_VIEW, webpage)
                view.getContext().startActivity(webIntent);
            })
        }
    }

}