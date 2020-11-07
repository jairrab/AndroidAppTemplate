package com.template.app.repository

import com.template.app.model.entities.GithubRepo
import com.template.app.repository.response.GitHubResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getRepos(user: String): GitHubResponse
    suspend fun getReposAndCache(user: String)
    fun getRepos(): Flow<List<GithubRepo>>
}