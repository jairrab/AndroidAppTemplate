package com.template.app.repository.implementation

import com.template.app.remote.GithubApi
import com.template.app.repository.Repository
import com.template.app.repository.mappers.GithubRepoMapper
import com.template.app.repository.response.GitHubResponse
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val githubRepoMapper: GithubRepoMapper,
) : Repository {
    override suspend fun getRepos(user: String): GitHubResponse {
        return try {
            val list = githubApi.getRepos(user).map { githubRepoMapper.map(it) }
            GitHubResponse.Success(list)
        } catch (e: Exception) {
            GitHubResponse.Fail(e)
        }
    }
}