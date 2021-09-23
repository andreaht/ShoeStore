package com.udacity.shoestore

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.util.ObservableViewModel
import timber.log.Timber

class ShoeDetailViewModel : ObservableViewModel() {

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