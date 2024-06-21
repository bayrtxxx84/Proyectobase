package com.torres.mvvmproject.data.network.firebase.entities

data class UsersFB(
    var id: Int = 0,
    var name: String,
    val pass: String = "",
    val image: String = "",
    val url: String = "",
    val age: Int = 0
)