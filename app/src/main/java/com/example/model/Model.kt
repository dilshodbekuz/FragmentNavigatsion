package com.example.test.model

data class Model(
    val duration: Int,
    val id: Int,
    val pageURL: String,
    val picture_id: String,
    val tags: String,
    val type: String,
    val videos: Videos,
    val height: Int,
    val size: Int,
    val url: String,
    val width: Int
)