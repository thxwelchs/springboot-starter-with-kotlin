package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable
import java.time.LocalDateTime

@NoRepositoryBean
interface BaseEntityRepository<T, ID : Serializable?>: JpaRepository<T, ID> {
    fun findByCreatedAtBetween(start: LocalDateTime, end: LocalDateTime): MutableList<T>
}