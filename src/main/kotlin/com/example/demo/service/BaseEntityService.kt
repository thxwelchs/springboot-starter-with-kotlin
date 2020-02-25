package com.example.demo.service

import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.io.Serializable
import javax.persistence.EntityManager
import kotlin.reflect.KClass

/**
 * Entity 공통 Service
 * Generics description
 * E: Entity, ID: Entity Primary Key (직렬화 할 수 있는 형태의 자료 형태)
 *
 * SimpleJpaRepository는 JpaRepository의 실질적인 구현체 클래스입니다.
 * SimpleJpaRepository를 상속받기 위해선 반드시 super생성자로 클래스를 초기화 해주어야 하는 것 같은데,
 * 그 super 생성자는 찾아보니 두개의 생성자로 오버로딩 되어 있고, 저는 그 중 하나인
 * entity의 클래스 타입과, entityManager를 받는 생성자로 슈퍼클래스 상속받게 했습니다.
 */
abstract class BaseEntityService<E : Any, ID : Serializable?>(
        clazz: KClass<E>,
        entityManager: EntityManager) : SimpleJpaRepository<E, ID>(clazz.java, entityManager) {
}