package com.template.app.repository.response

import com.template.app.remote.GitHubRepo

sealed class GitHubResponse {
    class Success(val data: List<GitHubRepo>) : GitHubResponse()
    class Fail(val error: Throwable) : GitHubResponse()
}