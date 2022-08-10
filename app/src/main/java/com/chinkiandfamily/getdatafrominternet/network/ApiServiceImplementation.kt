package com.chinkiandfamily.getdatafrominternet.network

import com.chinkiandfamily.getdatafrominternet.model.Post
import javax.inject.Inject

class ApiServiceImplementation @Inject constructor(private val apiService: ApiService) {
    suspend fun getPost(): List<Post> = apiService.getPost()
}