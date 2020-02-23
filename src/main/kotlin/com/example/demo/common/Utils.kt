package com.example.demo.common

import org.springframework.http.ResponseEntity


fun <T> apiOK(body: T?): ResponseEntity<T?> {
    val builder = ResponseEntity.ok()
    return builder.body(body)
}