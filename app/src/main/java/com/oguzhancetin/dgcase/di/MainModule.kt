package com.oguzhancetin.dgcase.di

import com.oguzhancetin.dgcase.BASE_URL
import com.oguzhancetin.dgcase.network.DgApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    fun retrofitInstance(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
    @Provides
    fun provideDgApi(): DgApi{
        return retrofitInstance().create(DgApi::class.java)
    }

}