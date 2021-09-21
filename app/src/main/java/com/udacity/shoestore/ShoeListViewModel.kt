package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel: ViewModel() {



    // The current word
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init{
        Timber.i("ShoeListViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeListViewModel destroyed!")
    }

}