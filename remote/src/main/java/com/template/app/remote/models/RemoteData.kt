package com.template.app.remote.models

import com.squareup.moshi.Json

data class RemoteData(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "html_url") val htmlUrl: String,
)