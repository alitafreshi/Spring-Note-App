package com.alitafreshi.note_app.exception_manager.handler

import com.alitafreshi.note_app.exception_manager.model.BaseAppException
import com.alitafreshi.note_app.exception_manager.model.BaseErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(BaseAppException::class)
    fun handleGlobalException(baseAppException: BaseAppException): ResponseEntity<BaseErrorResponse> {
        val errorResponse = BaseErrorResponse(errorCode = baseAppException.errorCode.value(), errorMessage = baseAppException.errorMessage)
        return ResponseEntity(errorResponse, baseAppException.errorCode)
    }

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(Exception::class)
    fun handleUnExpectedException(unExpectedException: Exception): ResponseEntity<BaseErrorResponse> {
        val errorResponse = BaseErrorResponse(errorCode = HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage = unExpectedException.localizedMessage)
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}