package com.torres.mvvmproject.logic.usercase

class DecriptMessageFromImage(val firebaseConnetion: String) {

    fun invoke(): String {
        return firebaseConnetion
    }

}