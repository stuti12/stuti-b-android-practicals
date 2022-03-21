package com.example.myapplication.com.example.myapplication.webService.retrofit

data class DataModal(// string variables for our name and job
    var name: String, var job: String
)
data class PostResponse(
    var name: String,
    var job: String,
    var id: String,
    var createdAt: String
)