package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailViewModel : ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    init{
        _shoe.value  =  Shoe("Zoom",12.0,"Nike","great shoes", mutableListOf())
        Timber.i("created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("destroyed!")
    }
}