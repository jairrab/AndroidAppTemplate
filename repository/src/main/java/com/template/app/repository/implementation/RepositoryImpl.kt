package com.template.app.repository.implementation

import com.template.app.remote.GithubApi
import com.template.app.repository.Repository
import com.template.app.repository.response.GitHubResponse
import javax.inject.Inject

internal class RepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
) : Repository {
    override suspend fun listRepos(user: String): GitHubResponse {
        return try {
            val response = githubApi.listRepos(user)
            GitHubResponse.Success(response)
        } catch (e: Exception) {
            GitHubResponse.Fail(e)
        }
    }
}