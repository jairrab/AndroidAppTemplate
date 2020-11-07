package com.template.app.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GITHUB_REPO")
data class GithubRepo(
    @PrimaryKey
    @ColumnInfo(name = "github_repo_id") val id: String,
    @ColumnInfo(name = "github_repo_html_url") val htmlUrl: String
)