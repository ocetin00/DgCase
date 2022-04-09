package com.oguzhancetin.dgcase.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT

interface DgApi {

    @PUT("/hash/oguzhan-cetin-21252")
    suspend fun getHashMessage(@Body body: RequestBody): Response<HashResponse>
}