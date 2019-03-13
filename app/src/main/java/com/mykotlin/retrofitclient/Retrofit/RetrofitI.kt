package com.mykotlin.retrofitclient.Retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import com.mykotlin.retrofitclient.Model.Post

interface RetrofitI {
    @get:GET("posts")
    val posts:Observable<List<Post>>
}