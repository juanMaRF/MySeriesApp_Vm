package com.juanrivera.myseriesapp_vm.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juanrivera.myseriesapp_vm.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view  = signUpBinding.root
        setContentView(view)
        setContentView(view)
    }
}