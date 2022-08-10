package com.chinkiandfamily.getdatafrominternet.repository

import com.chinkiandfamily.getdatafrominternet.model.Post
import com.chinkiandfamily.getdatafrominternet.network.ApiService
import com.chinkiandfamily.getdatafrominternet.network.ApiServiceImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServiceImplementation: ApiServiceImplementation) {
    fun getPost(): Flow<List<Post>> = flow {
        emit(apiServiceImplementation.getPost())
    }.flowOn(Dispatchers.IO)
}