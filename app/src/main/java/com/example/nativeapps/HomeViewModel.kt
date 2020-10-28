package com.example.nativeapps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private var _person = MutableLiveData<Person>()
    val person: LiveData<Person>
    get() = _person


    fun onCreateButtonClicked() {
        _person.value = Person("HEllo", "name")
    }
}