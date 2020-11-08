package com.template.app.repository

import com.template.app.model.entities.Data
import com.template.app.repository.response.ServerResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getDataList(user: String): ServerResponse
    suspend fun saveDataList(user: String)
    fun getDataFlow(): Flow<List<Data>>
}