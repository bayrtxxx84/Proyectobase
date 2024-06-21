package com.torres.mvvmproject.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.torres.mvvmproject.databinding.ActivityMainBinding
import com.torres.mvvmproject.di.SingletonComponets
import com.torres.mvvmproject.logic.usercase.DecriptMessageFromImage
import com.torres.mvvmproject.ui.data.UsersUI
import com.torres.mvvmproject.ui.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var x: String

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables("Val1")
        initListeners()
        intiObservables()
    }

    private fun intiObservables() {
        mainActivityViewModel.users.observe(this) {
            if (it.name.isBlank()) {
                binding.textView.text = "No hay datos"
            } else {
                binding.textView.text = it.toString()
            }
        }

        mainActivityViewModel.error.observe(this) {
            Snackbar.make(binding.textView, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun initListeners() {
        binding.button1.setOnClickListener {
            mainActivityViewModel.getUsersFromFirebase(0, "Facebook")
        }


        binding.button2.setOnClickListener {
            mainActivityViewModel.getUsersFromFirebase(1, "Correo")
        }


        binding.button3.setOnClickListener {
            mainActivityViewModel.getUsersFromFirebase(3, "Google")
        }
    }


    private fun initVariables(name: String) {
        x =
            DecriptMessageFromImage(
                SingletonComponets
                    .getFirebaseConnection(name)
            ).invoke()
    }


}