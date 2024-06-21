package com.torres.mvvmproject.logic.usercase

import com.torres.mvvmproject.data.network.firebase.repositories.RecoveryUsers
import com.torres.mvvmproject.ui.data.UsersUI

class GetAllUsersFromFirebase(val recoveryUsers: RecoveryUsers) {

    suspend fun invoke(position: Int, auth: String): Result<UsersUI> {

        var us: Result<UsersUI>? = null
        val x = recoveryUsers.getUsers()

        x.onSuccess {
            us = if (it.size > position) {
                Result.success(
                    UsersUI(
                        it[position].id,
                        it[position].name,
                        it[position].image, auth
                    )
                )
            } else {
                Result.failure(Exception("El indice esta fuera del rango"))
            }
        }

        x.onFailure {
            us = Result.failure(it)
        }

        return us!!
    }
}