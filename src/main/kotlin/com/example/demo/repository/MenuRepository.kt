package com.example.demo.repository

import com.example.demo.model.Menu
import com.example.demo.model.QMenu
import com.example.demo.model.QRestaurant
import org.springframework.data.domain.PageImpl
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.transaction.annotation.Transactional

interface MenuRepository: BaseEntityRepository<Menu, Int>, MenuRepositoryCustom {
//    @Query("SELECT m FROM Menu m JOIN FETCH m.restaurant")
//    override fun findAll(): MutableList<Menu>
}

interface MenuRepositoryCustom {
    fun findAllJoinRestaurant(): MutableList<Menu>
}

class MenuRepositoryCustomImpl: MenuRepositoryCustom, QuerydslRepositorySupport(Menu::class.java) {

    override fun findAllJoinRestaurant(): MutableList<Menu> {
        val m = QMenu.menu

        return from(m)
                .select(m)
                .leftJoin(m.restaurant)
                .fetchJoin()
                .fetch()
    }
}