package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init{
        _shoeList.value = mutableListOf()
        Timber.i("ShoeListViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeListViewModel destroyed!")
    }

}