package com.template.app.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.template.app.model.entities.GithubRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class GithubRepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveGithubRepos(list: List<GithubRepo>)

    @Query(
        """
        SELECT * FROM GITHUB_REPO 
        """
    )
    abstract fun getGithubRepos(): Flow<List<GithubRepo>>

    @ExperimentalCoroutinesApi
    fun getGithubReposDistinctUntilChanged(): Flow<List<GithubRepo>> {
        return getGithubRepos().distinctUntilChanged()
    }
}
