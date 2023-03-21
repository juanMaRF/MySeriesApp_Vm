package com.juanrivera.myseriesapp_vm.ui.signup

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.juanrivera.myseriesapp_vm.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view  = signUpBinding.root
        setContentView(view)

        signUpBinding.registerButton.setOnClickListener{
            val name = signUpBinding.nameEditText.text.toString()
            val email = signUpBinding.emailEditText.text.toString()
            val password = signUpBinding.passwordEditText.text.toString()
            val repPassword = signUpBinding.repPasswordEditText.text.toString()
            var genre = "Femenino"
            if(signUpBinding.maleRadioButton.isChecked)
                genre = "Masculino"
            else
                genre = "Femenino"

            var favoritesgenre = ""
            if (signUpBinding.actionButton.isChecked) favoritesgenre = "Acción"
            if (signUpBinding.comedyButton.isChecked) favoritesgenre += " Comedia"
            if (signUpBinding.suspenceButton.isChecked) favoritesgenre += " Suspenso"
            if (signUpBinding.dramaButton.isChecked) favoritesgenre += " Drama"

            val datepicker = signUpBinding.datePicker1
            val today = Calendar.getInstance()
            var cumple = datepicker.dayOfMonth.toString() + "/" + (datepicker.month + 1).toString() + "/" + datepicker.year.toString()

            var nacimiento = ""
            if (signUpBinding.spinner2.selectedItemPosition == 0){
                Toast.makeText(applicationContext,"Debes elegir una ciudad", Toast.LENGTH_LONG).show()
            }else{
                nacimiento = signUpBinding.spinner2.getItemAtPosition(signUpBinding.spinner2.selectedItemPosition).toString()
            }

            val info = "Nombre: $name\nEmail: $email\nPassword: $password\nGenre: $genre\nFavorites Genres: $favoritesgenre\nCiudad de nacimiento: $nacimiento\nFecha de nacimiento: $cumple"

            if (password == repPassword)
                signUpBinding.infoTextView.text = info
            else{
                Toast.makeText(applicationContext,"Las contraseñas no son iguales", Toast.LENGTH_LONG).show()  //LENGTH_SHORT
                signUpBinding.repPassword.error = "Las contraseñas no son iguales"
                Snackbar.make(signUpBinding.linearLayout, "Las contraseñas no son iguales", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Aceptar"){
                        signUpBinding.repPasswordEditText.setText("")
                        signUpBinding.repPassword.isErrorEnabled = false
                    }
                    .show()

            }

        }
    }
}