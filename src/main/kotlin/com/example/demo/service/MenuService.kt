package com.example.demo.service

import com.example.demo.model.Menu
import com.example.demo.repository.MenuRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class MenuService(
        private val menuRepository: MenuRepository,
        private val entityManager: EntityManager
): BaseEntityService<Menu, Int>(Menu::class, entityManager) {
}