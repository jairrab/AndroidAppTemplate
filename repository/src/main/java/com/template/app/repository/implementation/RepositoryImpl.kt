package com.template.app.repository.implementation

import com.template.app.model.LocalDb
import com.template.app.model.entities.Data
import com.template.app.remote.ServerApi
import com.template.app.repository.Repository
import com.template.app.repository.mappers.Mapper
import com.template.app.repository.response.ServerResponse
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val serverApi: ServerApi,
    private val mapper: Mapper,
    private val localDb: LocalDb,
) : Repository {
    override suspend fun getDataList(user: String): ServerResponse {
        return try {
            Timber.v("Getting remote data for $user...")
            val list = serverApi.getRepos(user).map { mapper.map(it) }
            Timber.v("Retrieved ${list.size} items from remote")
            ServerResponse.Success(list)
        } catch (e: Exception) {
            Timber.e(e)
            ServerResponse.Fail(e)
        }
    }

    override suspend fun saveDataList(user: String) {
        try {
            Timber.v("Getting remote data for $user...")
            val list = serverApi.getRepos(user).map { mapper.map(it) }
            Timber.v("Retrieved ${list.size} items from remote")
            localDb.saveDataList(list)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    override fun getDataFlow(): Flow<List<Data>> {
        return localDb.getDataList()
    }
}