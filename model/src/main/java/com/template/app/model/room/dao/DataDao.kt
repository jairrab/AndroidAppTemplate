package com.template.app.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.template.app.model.entities.Data
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveGithubRepos(list: List<Data>)

    @Query(
        """
        SELECT * FROM DATA_TABLE 
        """
    )
    abstract fun getGithubRepos(): Flow<List<Data>>

    @ExperimentalCoroutinesApi
    fun getGithubReposDistinctUntilChanged(): Flow<List<Data>> {
        return getGithubRepos().distinctUntilChanged()
    }
}
