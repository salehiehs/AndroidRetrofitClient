package com.mykotlin.retrofitclient.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mykotlin.retrofitclient.Model.Post
import kotlin.example.administrator.retrofitclient.R

class PostAdapter(internal var context: Context,internal var postlist:List<Post>):RecyclerView.Adapter<PostViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PostViewHolder {
       val itemView = LayoutInflater.from(parent.context)
               .inflate(R.layout.post_layout,parent,false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return postlist.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.txt_author.text = postlist[position].userId.toString()
        holder.txt_title.text = postlist[position].title.toString()
        holder.txt_content.text = StringBuilder(postlist[position].body.substring(0,20))
                .append("...").toString()
    }


}