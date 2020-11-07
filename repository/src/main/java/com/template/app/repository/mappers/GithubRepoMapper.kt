package com.template.app.repository.mappers

import com.template.app.model.entities.GithubRepo
import com.template.app.remote.models.RemoteGitHubRepo
import javax.inject.Inject

class GithubRepoMapper @Inject constructor() {
    fun map(data: RemoteGitHubRepo): GithubRepo {
        return GithubRepo(
            id = data.id,
            htmlUrl = data.html_url
        )
    }
}