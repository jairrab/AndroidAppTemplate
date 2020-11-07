package com.template.app.repository.implementation

import com.template.app.remote.GithubService
import com.template.app.repository.Repository
import com.template.app.repository.response.GitHubResponse
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val githubService: GithubService
) : Repository {
    override suspend fun listRepos(user: String): GitHubResponse {
        val response = githubService.listRepos(user)
        return try {
            if (response.isSuccessful) {
                GitHubResponse.Success(response.body() ?: ArrayList())
            } else {
                GitHubResponse.Fail(Exception(response.message()))
            }
        } catch (e: Exception) {
            GitHubResponse.Fail(Exception(response.message()))
        }
    }
}