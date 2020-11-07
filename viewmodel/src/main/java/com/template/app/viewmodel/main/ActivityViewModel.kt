package com.template.app.viewmodel.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.jairrab.androidutilities.eventobserver.Event
import com.template.app.viewmodel.BaseViewModel

class ActivityViewModel @ViewModelInject constructor(
) : BaseViewModel() {
    private val _checkSetupLd = MutableLiveData<Event<Unit>>()
    val checkSetupLd: LiveData<Event<Unit>> get() = _checkSetupLd

    fun checkSetup() {
        _checkSetupLd.value = Event(Unit)
    }
}