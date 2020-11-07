package com.template.app.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.template.app.model.entities.GithubRepo

@Dao
abstract class GithubRepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveGithubRepos(list: List<GithubRepo>)
}
