package com.example.demo.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
//@WebMvcTest(MenuController::class)
@AutoConfigureMockMvc
internal class MenuControllerTest(private val mockMvc: MockMvc) {

    @Test
    fun `data class 엔티티의 메뉴를 조회 하는 컨트롤러 테스트`() {
        mockMvc.perform(get("/v1/menus/2"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("김치찌개"))
                .andExpect(jsonPath("$.price").value(BigDecimal("8000.0")))
                .andExpect(jsonPath("$.restaurant.name").value("찌개잘하는집"))
    }
}