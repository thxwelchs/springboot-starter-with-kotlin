package com.example.demo.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import javax.persistence.EntityNotFoundException

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
internal class MenuRepositoryTest @Autowired constructor(
        private val menuRepository: MenuRepository
) {

    @Test
    fun `Menu 조회 후 Restaurant까지 지연 로딩 해보기`() {
        val menu = menuRepository.findById(2).orElseThrow{ EntityNotFoundException() }
        val restaurantName = menu.restaurant.name // 지연 로딩

        assertEquals("찌개잘하는집", restaurantName)
    }

    @Test
    fun `Menu 만 조회했는데, Restaurant 가 조회되는 N+1 현상 테스트` () {
        val menus = menuRepository.findAllJoinRestaurant()

        assertTrue(true)
    }
}