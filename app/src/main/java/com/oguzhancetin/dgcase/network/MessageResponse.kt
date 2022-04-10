package com.oguzhancetin.dgcase.network

sealed class MessageResponse<out T>(
    val message: String? = null,
    val data: T? = null
){
    class Error(message: String) : MessageResponse<String>(message = message)
    class Loading() : MessageResponse<String>()
    class Success(response: HashResponse) : MessageResponse<HashResponse>(data = response)
}


