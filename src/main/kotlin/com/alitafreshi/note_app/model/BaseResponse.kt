package com.alitafreshi.note_app.model

data class BaseResponse<T>(val response: T, val status: ResponseStatus)
