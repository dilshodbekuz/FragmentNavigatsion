package com.example.api.baseResponse

data class BasePexelsResponse<T> (
    var page:Int,
    var per_page:Int,
    var photos:T
)