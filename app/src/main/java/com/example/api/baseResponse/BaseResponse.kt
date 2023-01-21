package com.example.api.baseResponse


data class BaseResponse<T>(
    var total:Int,
    var totalHits:Int,
    var hits:T
)
