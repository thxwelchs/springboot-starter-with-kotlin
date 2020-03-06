package com.example.demo.repository

import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import javax.persistence.EntityNotFoundException

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
internal class RestaurantRepositoryTest @Autowired constructor(
        private val restaurantRepository: RestaurantRepository
) {

    @Test
    fun `Restaurant 조회 후 Menu까지 지연 로딩 해보기`() {
//        assertThrows(StackOverflowError::class.java) {
            val restaurant = restaurantRepository.findById(1).orElseThrow{ EntityNotFoundException() }
            val menus = restaurant.menus.size // 지연 로딩
//        }
        assertEquals(3, menus)
    }
}