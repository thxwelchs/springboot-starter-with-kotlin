package com.example.demo.controller

import mu.KotlinLogging
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.persistence.EntityNotFoundException
import javax.servlet.http.HttpServletRequest


@RestControllerAdvice
class APIControllerAdvice {
    private val logger = KotlinLogging.logger{}

    @ExceptionHandler(EntityNotFoundException::class)
    fun noContentException(): ResponseEntity<Any?> {
        return ResponseEntity.noContent().build()
    }

    @ExceptionHandler(Exception::class)
    fun internalServerException(request: HttpServletRequest, e: Exception): ResponseEntity<String> {
        logger.error("{ \"sessionID\": ${request.requestedSessionId}, \"requestURI\": \"${request.requestURI}\", \"error\": \"${e.message}\" }")
        return ResponseEntity("ERROR: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
    }
}