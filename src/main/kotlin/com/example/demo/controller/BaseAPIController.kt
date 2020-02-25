package com.example.demo.controller

import com.example.demo.service.BaseEntityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.Serializable
import javax.persistence.EntityNotFoundException

/**
 * Rest API 공통 컨트롤러
 * Generics description
 * E: Entity, ID: Entity Primary Key (직렬화 할 수 있는 형태의 자료 형태), S: 해당 엔티티의 비즈니스 로직을 처리하기 위한 서비스 클래스 (BaseEntityService를 상속하는 객체 여야 함.)
 */
@RestController
abstract class BaseAPIController<E : Any, ID : Serializable, S : BaseEntityService<E, ID>> {
    @Autowired
    lateinit var service: S

    @GetMapping("/{id}")
    fun getOneByID(@PathVariable id: ID): ResponseEntity<E> {
        return ResponseEntity.ok(service.findById(id).orElseThrow { EntityNotFoundException() })
    }

    @GetMapping
    fun get(): ResponseEntity<MutableList<E>?> {
        return ResponseEntity.ok(service.findAll())
    }

    @PostMapping
    fun create(entity: E): ResponseEntity<E> {
        return ResponseEntity.ok(service.save(entity))
    }

    @PutMapping
    fun update(entity: E): ResponseEntity<E> {
        return ResponseEntity.ok(service.save(entity))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: ID) {
        service.deleteById(id)
    }

    @DeleteMapping
    fun delete(entity: E) {
        service.delete(entity)
    }
}