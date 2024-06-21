package com.torres.mvvmproject.data.network.firebase.repositories

import com.torres.mvvmproject.data.network.firebase.entities.UsersFB

class RecoveryUsers {

    fun getUsers(): Result<List<UsersFB>> {
        return kotlin.runCatching {
             listOf(
                UsersFB(0, "Bayron"),
                UsersFB(1, "Jorge"),
                UsersFB(2, "Dennis")
            )
        }
    }
}