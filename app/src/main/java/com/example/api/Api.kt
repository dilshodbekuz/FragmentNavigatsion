package com.example.api


import com.example.api.baseResponse.BasePexelsResponse
import com.example.api.baseResponse.BaseResponse
import com.example.model.ModelList
import com.example.model.Pexels
import com.example.test.model.ImageModel
import com.example.test.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("api/?key=29361305-c1438b29d2fb14c66d5a7b065&q=yellow+flowers&image_type=photo")
    fun getImage(): Call<BaseResponse<List<ImageModel>>>

    @GET("api/videos/?key=29361305-c1438b29d2fb14c66d5a7b065&q=yellow+flowers")
    fun getVideos(): Call<BaseResponse<List<Model>>>

    @GET("products")
    fun getPexelsImage():Call<List<ModelList>>
}