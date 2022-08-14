package com.udacity.shoestore.ui.shoe_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.udacity.shoestore.models.Shoe

class ShoesListViewModel : ViewModel() {


    var size = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var description = MutableLiveData<String>()


    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    init {
        restFields()
    }

    val shoes: LiveData<List<Shoe>>
        get() = _shoes.map { it.toList() }


    fun addShoe() {
        try {
            _shoes.value!!.add(
                Shoe(
                    name = name.value!!,
                    size = size.value!!.toDouble(),
                    company = company.value!!,
                    description = description.value!!
                )
            )
            restFields()
        } catch (_: Exception) {
        }
    }


    private fun restFields() {
        this.size.value = ""
        this.name.value = ""
        this.company.value = ""
        this.description.value = ""
    }

    fun clearList(){
        this._shoes.value = mutableListOf()
    }

}