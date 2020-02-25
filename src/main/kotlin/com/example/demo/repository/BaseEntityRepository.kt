package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.LockModeType
import javax.persistence.NamedQuery

@NoRepositoryBean
interface BaseEntityRepository<T, ID : Serializable?>: JpaRepository<T, ID> {
    fun findByCreatedAtBetween(start: LocalDateTime, end: LocalDateTime): MutableList<T>

    @Query("SELECT t FROM #{#entityName} t WHERE t.id >= :id") // 이런식으로 T로 받은 제네릭을 JPQL에서도 활용 가능합니다.
    fun findByBiggerId(id: ID): MutableList<T>

    @Query("SELECT t FROM #{#entityName} t WHERE t.id = :id")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun findByIdWithExclusiveLock(id: ID): T

    @Query("SELECT t FROM #{#entityName} t WHERE t.id = :id")
    @Lock(LockModeType.PESSIMISTIC_READ)
    fun findByIdWithSharedLock(id: ID): T
}