package com.example.nativeapps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    private var _person = MutableLiveData<Person>()
    val person: LiveData<Person>
        get() = _person

    fun updatePerson(firstName: String, lastName: String) {
        _person.value = Person(firstName, lastName)
    }
}