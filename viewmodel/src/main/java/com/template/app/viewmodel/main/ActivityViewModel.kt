package com.template.app.viewmodel.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.jairrab.androidutilities.eventobserver.Event
import com.template.app.repository.Repository
import com.template.app.repository.response.GitHubResponse
import com.template.app.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ActivityViewModel @ViewModelInject constructor(
    private val repository: Repository
) : BaseViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    init {
        viewModelScope.launch {
            repository.getRepos().collect {
                if (it.isEmpty()) return@collect
                _result.value = "${it.size} items observed from Room"
            }
        }
    }

    private val _activityViewModelSetupLd = MutableLiveData<Event<Unit>>()
    val activityViewModelSetupLd: LiveData<Event<Unit>> get() = _activityViewModelSetupLd

    fun checkActivityViewModelSetup() {
        _activityViewModelSetupLd.value = Event(Unit)
    }

    fun checkRetrofit(user: String) = viewModelScope.launch {
        when (val response = repository.getRepos(user)) {
            is GitHubResponse.Success -> {
                val data = "${response.data.size} items received"
                _result.value = data
            }
            is GitHubResponse.Fail -> _result.value = response.error.message
        }
    }

    fun checkRoom(user: String) = viewModelScope.launch {
        repository.getReposAndCache(user)
    }
}