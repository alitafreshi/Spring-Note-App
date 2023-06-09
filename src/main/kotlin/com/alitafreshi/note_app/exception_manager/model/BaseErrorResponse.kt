package com.alitafreshi.note_app.exception_manager.model

data class BaseErrorResponse(val errorMessage: String, val status: RequestStatus)

data class RequestStatus(val code: Int, val description: String)