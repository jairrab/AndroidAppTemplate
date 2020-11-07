package com.template.app.model.implementation

import com.template.app.model.LocalDb
import com.template.app.model.entities.GithubRepo
import com.template.app.model.room.AppDatabase

internal class LocalDbImpl(
    private val appDatabase: AppDatabase,
) : LocalDb {
    override suspend fun saveGithubRepos(list: List<GithubRepo>) {
        appDatabase.githubRepoDao.saveGithubRepos(list)
    }
}