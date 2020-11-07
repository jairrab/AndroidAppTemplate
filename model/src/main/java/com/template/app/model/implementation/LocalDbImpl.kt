package com.template.app.model.implementation

import com.template.app.model.LocalDb
import com.template.app.model.entities.Data
import com.template.app.model.room.AppDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

internal class LocalDbImpl(
    private val appDatabase: AppDatabase,
) : LocalDb {
    override suspend fun saveDataList(list: List<Data>) {
        try {
            appDatabase.dataDao.saveGithubRepos(list)
            Timber.v("saveGithubRepos ${list.size} items")
        } catch (e: Exception) {
            Timber.e(e)
            throw e
        }
    }

    @ExperimentalCoroutinesApi
    override fun getDataList(): Flow<List<Data>> {
        Timber.v("Getting flowable data")
        return appDatabase.dataDao.getGithubReposDistinctUntilChanged()
    }
}