package com.example.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    var retrofit: Retrofit? = null

    fun apiImage(): Api {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }

    fun apiPexels(): Api {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }
}