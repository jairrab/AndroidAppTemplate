package com.template.app.model

import com.template.app.model.entities.GithubRepo
import kotlinx.coroutines.flow.Flow

interface LocalDb {
    suspend fun saveGithubRepos(list: List<GithubRepo>)
    fun getRepos(): Flow<List<GithubRepo>>
}