package com.mykotlin.retrofitclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import com.mykotlin.retrofitclient.Adapter.PostAdapter
import com.mykotlin.retrofitclient.Model.Post
import com.mykotlin.retrofitclient.Retrofit.RetrofitClient
import com.mykotlin.retrofitclient.Retrofit.RetrofitI
import kotlin.example.administrator.retrofitclient.R

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi: RetrofitI
    internal lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient.instance
        jsonApi = retrofit.create(RetrofitI::class.java)

        recyceler_post.setHasFixedSize(true);
        recyceler_post.layoutManager = LinearLayoutManager(this )
        fetchData()

    }

    private fun fetchData() {
       compositeDisposable.add(jsonApi.posts
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe{posts->displayData(posts)})
    }

    private fun displayData(posts: List<Post>?) {

        val adapter = PostAdapter(this, posts!!)
        recyceler_post.adapter = adapter

    }
}
