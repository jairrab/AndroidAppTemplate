package com.template.app.repository.response

import com.template.app.model.entities.GithubRepo

sealed class GitHubResponse {
    class Success(val data: List<GithubRepo>) : GitHubResponse()
    class Fail(val error: Throwable) : GitHubResponse()
}