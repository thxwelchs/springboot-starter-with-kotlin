package com.example.demo.model.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseIntAIEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "INT UNSIGNED", nullable = false)
        var id: Int? = null
): Serializable

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class ImmutableEntity(

        @CreatedDate
        @Column(name = "created_at", columnDefinition = "DATETIME", nullable = false, updatable = false)
        var createdAt: LocalDateTime = LocalDateTime.now()
): BaseIntAIEntity()

@MappedSuperclass
@EntityListeners(value =[AuditingEntityListener::class])
abstract class MutableEntity(
        @LastModifiedDate
        @Column(name = "updated_at", columnDefinition = "DATETIME", nullable = true, updatable = true)
        var updatedAt: LocalDateTime? = null
): ImmutableEntity()

abstract class ImmutableDTO(
        var id: Int? = null,
        var createdAt: LocalDateTime = LocalDateTime.now()
): Serializable

abstract class MutableDTO(
        var updatedAt: LocalDateTime? = null
): ImmutableDTO()