package com.template.app.model.implementation

import com.template.app.model.LocalDb
import com.template.app.model.entities.GithubRepo
import com.template.app.model.room.AppDatabase
import timber.log.Timber

internal class LocalDbImpl(
    private val appDatabase: AppDatabase,
) : LocalDb {
    override suspend fun saveGithubRepos(list: List<GithubRepo>) {
        try {
            appDatabase.githubRepoDao.saveGithubRepos(list)
            Timber.v("saveGithubRepos ${list.size} items")
        } catch (e: Exception) {
            Timber.e(e)
            throw e
        }
    }
}