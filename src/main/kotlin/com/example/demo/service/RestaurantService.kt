package com.example.demo.service

import com.example.demo.model.Restaurant
import com.example.demo.repository.RestaurantRepository
import mu.KotlinLogging
import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct
import javax.persistence.EntityManager

@Service
class RestaurantService(
        private val restaurantRepository: RestaurantRepository,
        private val entityManager: EntityManager
) : BaseEntityService<Restaurant, Int>(Restaurant::class, entityManager) {

}