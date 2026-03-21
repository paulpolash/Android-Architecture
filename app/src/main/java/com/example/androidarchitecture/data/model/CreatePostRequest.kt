package com.example.androidarchitecture.data.model

data class CreatePostRequest(
    val userId: Int,
    val title: String,
    val body: String
)