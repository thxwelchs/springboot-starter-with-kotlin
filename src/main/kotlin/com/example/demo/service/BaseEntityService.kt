package com.example.demo.service

import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.EntityNotFoundException
import kotlin.reflect.KClass

class BaseEntityService<T : Any, ID : Serializable?>(
        clazz: KClass<T>,
        entityManager: EntityManager) : SimpleJpaRepository<T, ID>(clazz.java, entityManager) {

}