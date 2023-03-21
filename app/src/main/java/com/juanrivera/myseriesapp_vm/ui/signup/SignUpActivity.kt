package com.juanrivera.myseriesapp_vm.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.juanrivera.myseriesapp_vm.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view  = signUpBinding.root
        setContentView(view)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        var nameObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }
        var emailObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }
        var passwordObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }
        var reppaswordObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }
        var genreObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }
        var favoritesgenreObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }
        var nacimientoObserver =Observer<String>{
            signUpBinding.infoTextView.text = it
        }

        mainViewModel.name.observe(this,nameObserver)
        mainViewModel.email.observe(this,emailObserver)
        mainViewModel.password.observe(this,passwordObserver)
        mainViewModel.reppassword.observe(this,reppaswordObserver)
        mainViewModel.genre.observe(this,genreObserver)
        mainViewModel.favoritesgenre.observe(this,favoritesgenreObserver)
        mainViewModel.nacimiento.observe(this,nacimientoObserver)

        signUpBinding.registerButton.setOnClickListener{
            mainViewModel.nombre(signUpBinding.nameEditText.text.toString())
            mainViewModel.correo(signUpBinding.emailEditText.text.toString())
            mainViewModel.contrase(signUpBinding.passwordEditText.text.toString())
            mainViewModel.confcontra(signUpBinding.passwordEditText.text.toString())
            mainViewModel.genero("Femenino")
            if(signUpBinding.maleRadioButton.isChecked)
                mainViewModel.genero("Masculino")
            else
                mainViewModel.genero("Femenino")

            mainViewModel.favoritos("")
            if (signUpBinding.actionButton.isChecked) mainViewModel.favoritesgenre.value = "Acción"
            if (signUpBinding.comedyButton.isChecked) mainViewModel.favoritesgenre.value += " Comedia"
            if (signUpBinding.suspenceButton.isChecked) mainViewModel.favoritesgenre.value += " Suspenso"
            if (signUpBinding.dramaButton.isChecked) mainViewModel.favoritesgenre.value += " Drama"

            val datepicker = signUpBinding.datePicker1
            mainViewModel.hb(datepicker.dayOfMonth.toString() + "/" + (datepicker.month + 1).toString() + "/" + datepicker.year.toString())

            if (signUpBinding.spinner2.selectedItemPosition == 0){
                Toast.makeText(applicationContext,"Debes elegir una ciudad", Toast.LENGTH_LONG).show()
            }else{
                mainViewModel.birth(signUpBinding.spinner2.getItemAtPosition(signUpBinding.spinner2.selectedItemPosition).toString())
            }

            val info = "Nombre: ${mainViewModel.name.value.toString()}\nEmail: " +
                    "${mainViewModel.email.value.toString()}\nPassword: " +
                    "${mainViewModel.password.value.toString()}\nGenre:" +
                    "${mainViewModel.genre.value.toString()}\nFavorites Genres:" +
                    "${mainViewModel.favoritesgenre.value.toString()}\nCiudad de nacimiento:" +
                    "${mainViewModel.nacimiento.value.toString()}\nFecha de nacimiento:" +
                    "${mainViewModel.cumple.value.toString()}"

            //Log.d("contra: ",mainViewModel.password.value.toString())
            //Log.d("cccontra: ",mainViewModel.reppassword.value.toString())
            if (mainViewModel.password.value.toString() == mainViewModel.reppassword.value.toString())
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