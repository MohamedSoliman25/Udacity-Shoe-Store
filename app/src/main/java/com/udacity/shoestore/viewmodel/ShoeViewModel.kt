package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private var shoeList:MutableList<Shoe> = ArrayList<Shoe>()
    private var _shoeLiveData = MutableLiveData<List<Shoe>>()
    val shoeLiveData :LiveData<List<Shoe>> get() = _shoeLiveData

     fun addShoe(shoe: Shoe){
        shoeList.add(shoe)
         _shoeLiveData.value = shoeList
    }

//    fun setShoeLiveData(){
//        _shoeLiveData.postValue(shoeList)
//    }


}