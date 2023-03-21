package com.juanrivera.myseriesapp_vm.ui.signup

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val email: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val password: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val reppassword: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val genre: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val favoritesgenre: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val nacimiento: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val cumple: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    fun nombre(nom:String){
        name.value = nom
    }
    fun correo(cor:String){
        email.value = cor
    }
    fun contrase(contrasena:String){
        password.value = contrasena
    }
    fun confcontra(repcontra:String){
        reppassword.value = repcontra
    }
    fun genero(gen:String){
        genre.value = gen
    }
    fun favoritos(fav:String){
        favoritesgenre.value = fav
    }
    fun birth(naci:String){
        nacimiento.value = naci
    }
    fun hb(cum:String){
        cumple.value = cum
    }
}