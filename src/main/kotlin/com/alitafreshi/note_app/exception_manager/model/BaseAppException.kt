package com.alitafreshi.note_app.exception_manager.model

import org.springframework.http.HttpStatus

data class BaseAppException(val errorCode: HttpStatus, val errorMessage: String) : Exception(errorMessage)
