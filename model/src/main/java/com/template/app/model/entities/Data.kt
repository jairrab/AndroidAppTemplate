package com.template.app.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DATA_TABLE")
data class Data(
    @PrimaryKey
    @ColumnInfo(name = "github_repo_id") val id: String,
    @ColumnInfo(name = "github_repo_html_url") val htmlUrl: String
)