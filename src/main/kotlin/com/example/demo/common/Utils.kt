package com.example.demo.common

import com.querydsl.jpa.JPQLQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import javax.persistence.Query

object Utils {

}
fun <T> apiOK(body: T?): ResponseEntity<T?> {
    val builder = ResponseEntity.ok()
    return builder.body(body)
}