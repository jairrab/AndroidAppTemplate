package com.template.app.model

import com.template.app.model.entities.GithubRepo

interface LocalDb {
    suspend fun saveGithubRepos(list: List<GithubRepo>)
}