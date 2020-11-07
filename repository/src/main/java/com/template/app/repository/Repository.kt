package com.template.app.repository

import com.template.app.repository.response.GitHubResponse

interface Repository {
    suspend fun listRepos(user: String): GitHubResponse
}