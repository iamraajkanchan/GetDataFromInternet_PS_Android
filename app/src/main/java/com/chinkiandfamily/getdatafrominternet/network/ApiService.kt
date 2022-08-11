package com.chinkiandfamily.getdatafrominternet.network

import com.chinkiandfamily.getdatafrominternet.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET(value = "posts")
    suspend fun getPost(): List<Post>
}