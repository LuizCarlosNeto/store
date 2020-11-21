package com.study.store.application.exception

import com.study.store.application.exception.error.ApiErrors
import com.study.store.domain.exception.BusinessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException

@RestControllerAdvice
class ApplicationControllerAdvice {

    @ExceptionHandler(BusinessException::class)
    fun handleResponseStatusException(ex: BusinessException): ResponseEntity<*>? {
        return ResponseEntity<Any?>(ApiErrors(message =  ex.message), HttpStatus.BAD_REQUEST)
    }

}