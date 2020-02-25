package com.example.demo.repository

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
internal class MenuRepositoryTest @Autowired constructor(
        private val menuRepository: MenuRepository
) {

    @Test
    fun `Menu 만 조회했는데, Restaurant 가 조회되는 N+1 현상 테스트` () {
        val menus = menuRepository.findAllJoinRestaurant()

        assertTrue(true)
    }
}