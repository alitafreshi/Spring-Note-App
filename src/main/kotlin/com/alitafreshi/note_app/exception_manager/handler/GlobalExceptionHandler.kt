package com.alitafreshi.note_app.exception_manager.handler

import com.alitafreshi.note_app.exception_manager.model.BaseAppException
import com.alitafreshi.note_app.exception_manager.model.BaseErrorResponse
import com.alitafreshi.note_app.exception_manager.model.RequestStatus
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
        val errorResponse = BaseErrorResponse(requestStatus = RequestStatus(code = baseAppException.errorCode.value(), description = baseAppException.errorCode.reasonPhrase), errorMessage = baseAppException.errorMessage)
        return ResponseEntity(errorResponse, baseAppException.errorCode)
    }

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(Exception::class)
    fun handleUnExpectedException(unExpectedException: Exception): ResponseEntity<BaseErrorResponse> {
        val requestStatus = HttpStatus.INTERNAL_SERVER_ERROR
        val errorResponse = BaseErrorResponse(requestStatus = RequestStatus(code = requestStatus.value(), description = requestStatus.reasonPhrase), errorMessage = unExpectedException.localizedMessage)
        return ResponseEntity(errorResponse, requestStatus)
    }
}