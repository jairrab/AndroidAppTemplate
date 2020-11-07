package com.template.app.repository.implementation

import com.template.app.model.LocalDb
import com.template.app.remote.GithubApi
import com.template.app.repository.Repository
import com.template.app.repository.mappers.GithubRepoMapper
import com.template.app.repository.response.GitHubResponse
import timber.log.Timber
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val githubRepoMapper: GithubRepoMapper,
    private val localDb: LocalDb,
) : Repository {
    override suspend fun getRepos(user: String): GitHubResponse {
        return try {
            Timber.v("Getting github repos for $user...")
            val list = githubApi.getRepos(user).map { githubRepoMapper.map(it) }
            Timber.v("Retrieved ${list.size} items from remote")
            GitHubResponse.Success(list)
        } catch (e: Exception) {
            Timber.e(e)
            GitHubResponse.Fail(e)
        }
    }

    override suspend fun getReposAndCache(user: String) {
        try {
            Timber.v("Getting github repos for $user...")
            val list = githubApi.getRepos(user).map { githubRepoMapper.map(it) }
            Timber.v("Retrieved ${list.size} items from remote")
            localDb.saveGithubRepos(list)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }
}