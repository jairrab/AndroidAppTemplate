package com.template.app.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jairrab.androidutilities.eventobserver.Event

class ActivityViewModel @ViewModelInject constructor(

) : ViewModel() {
    private val _checkSetupLd = MutableLiveData<Event<Unit>>()
    val checkSetupLd: LiveData<Event<Unit>> get() = _checkSetupLd

    fun checkSetup() {
        _checkSetupLd.value = Event(Unit)
    }
}