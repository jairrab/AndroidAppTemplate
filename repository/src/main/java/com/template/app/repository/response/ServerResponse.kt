package com.template.app.repository.response

import com.template.app.model.entities.Data

sealed class ServerResponse {
    class Success(val data: List<Data>) : ServerResponse()
    class Fail(val error: Throwable) : ServerResponse()
}