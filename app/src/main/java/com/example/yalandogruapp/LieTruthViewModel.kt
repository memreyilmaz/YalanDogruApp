package com.example.yalandogruapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LieTruthViewModel: ViewModel(){

    val lie = MutableLiveData<String>()
    val truth = MutableLiveData<String>()

    fun setTruth(truthedit: String){
        truth.value = truthedit
    }

    fun setLie(lieedit: String){
        lie.value = lieedit
    }

    fun lastTruthValue(): String? = truth.value
    fun lastLieValue(): String? = lie.value

}