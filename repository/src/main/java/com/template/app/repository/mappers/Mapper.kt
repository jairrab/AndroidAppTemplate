package com.template.app.repository.mappers

import com.template.app.model.entities.Data
import com.template.app.remote.models.RemoteData
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun map(data: RemoteData): Data {
        return Data(
            id = data.id,
            htmlUrl = data.html_url
        )
    }
}