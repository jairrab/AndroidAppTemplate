package com.template.app.model

import com.template.app.model.entities.Data
import kotlinx.coroutines.flow.Flow

interface LocalDb {
    suspend fun saveDataList(list: List<Data>)
    fun getDataList(): Flow<List<Data>>
}