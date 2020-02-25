package com.example.demo.service

import com.example.demo.model.Menu
import com.example.demo.repository.MenuRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.annotation.PostConstruct
import javax.persistence.EntityManager

@Service
class MenuService(
        private val menuRepository: MenuRepository,
        private val entityManager: EntityManager
) : BaseEntityService<Menu, Int>(Menu::class, entityManager) {

    override fun findAll(): MutableList<Menu> {
        return menuRepository.findAllJoinRestaurant()
    }

    fun findAllJoinRestaurant(): MutableList<Menu> {
        return menuRepository.findAllJoinRestaurant()
    }

    fun findByCreatedAtBetween(start: LocalDateTime, end: LocalDateTime): MutableList<Menu> {
        return menuRepository.findByCreatedAtBetween(start, end)
    }

}