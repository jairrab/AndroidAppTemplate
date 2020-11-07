package com.template.app.repository.mappers

import com.template.app.model.GithubRepo
import com.template.app.remote.models.RemoteGitHubRepo
import javax.inject.Inject

class GithubRepoMapper @Inject constructor() {
    fun map(data: RemoteGitHubRepo): GithubRepo {
        return GithubRepo(data.html_url)
    }
}