package com.template.app.viewmodel.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.jairrab.androidutilities.eventobserver.Event
import com.template.app.model.entities.GithubRepo
import com.template.app.repository.Repository
import com.template.app.repository.response.GitHubResponse
import com.template.app.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class ActivityViewModel @ViewModelInject constructor(
    private val repository: Repository
) : BaseViewModel() {
    private val _activityViewModelSetupLd = MutableLiveData<Event<Unit>>()
    val activityViewModelSetupLd: LiveData<Event<Unit>> get() = _activityViewModelSetupLd

    fun checkActivityViewModelSetup() {
        _activityViewModelSetupLd.value = Event(Unit)
    }

    private val _reposLd = MutableLiveData<List<GithubRepo>>()
    val reposLd: LiveData<List<GithubRepo>> get() = _reposLd

    fun checkRepository(user: String) = viewModelScope.launch {
        when (val response = repository.getRepos(user)) {
            is GitHubResponse.Success -> {
                _reposLd.value = response.data
            }
            is GitHubResponse.Fail -> {
                Timber.e(response.error)
            }
        }
    }
}