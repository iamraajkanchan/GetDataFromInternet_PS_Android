package com.chinkiandfamily.getdatafrominternet.network

import com.chinkiandfamily.getdatafrominternet.model.Post
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {
    suspend fun getPost(): List<Post> = apiService.getPost()
}