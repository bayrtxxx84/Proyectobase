package com.torres.mvvmproject.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torres.mvvmproject.data.network.firebase.repositories.RecoveryUsers
import com.torres.mvvmproject.logic.usercase.GetAllUsersFromFirebase
import com.torres.mvvmproject.ui.data.UsersUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val users get() = _users
    val error get() = _error

    private var _users = MutableLiveData<UsersUI>()
    private var _error = MutableLiveData<String>()

    fun getUsersFromFirebase(pos: Int, auth: String) {

        when (auth) {
            "Google" -> {
                viewModelScope.launch(Dispatchers.Default) {
                    val usersId = GetAllUsersFromFirebase(RecoveryUsers()).invoke(pos, auth)

                    usersId.onSuccess {
                        _users.postValue(it)
                    }
                    usersId.onFailure {
                        errorFunction(it)
                    }
                }
            }

            "Facebook" -> {
                viewModelScope.launch(Dispatchers.Default) {
                    val usersId = GetAllUsersFromFirebase(RecoveryUsers()).invoke(pos, auth)

                    usersId.onSuccess {
                        _users.postValue(it)
                    }
                    usersId.onFailure {
                        errorFunction(it)
                    }
                }
            }

            "Correo" -> {
                viewModelScope.launch(Dispatchers.Default) {
                    val usersId = GetAllUsersFromFirebase(RecoveryUsers()).invoke(pos, auth)

                    usersId.onSuccess {
                        _users.postValue(it)
                    }
                    usersId.onFailure {
                        errorFunction(it)
                    }
                }
            }
        }
    }

    private fun errorFunction(it: Throwable) {
        _users.postValue(UsersUI())
        _error.postValue(it.message.toString())
    }
}