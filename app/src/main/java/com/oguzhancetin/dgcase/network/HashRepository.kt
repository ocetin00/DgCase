package com.oguzhancetin.dgcase.network

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import javax.inject.Inject

class HashRepository  @Inject constructor (val api:DgApi) {

    val hashedMessage =  flow {
        emit(MessageResponse.Loading())
        val request = RequestBody("2bc104dd-72e4-4e3e-88b0-938b731590ee")
        val response = api.getHashMessage(request)
        if(response.isSuccessful){
            emit(MessageResponse.Success(response = response.body()!!))
        }else{
            emit(MessageResponse.Error(message = response.message()))
        }
    }


}