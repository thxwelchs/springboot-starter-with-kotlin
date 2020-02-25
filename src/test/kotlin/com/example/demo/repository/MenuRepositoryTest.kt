package com.example.demo.repository

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
//@ExtendWith(SpringExtension::class)
@WebAppConfiguration
@DataJpaTest
internal class MenuRepository @Autowired constructor(
        private val menuRepository: MenuRepository
) {

    @Test
    fun findAllJoinRestaurant() {
        menuRepository.findAllJoinRestaurant()
        println(" = ")
    }
}