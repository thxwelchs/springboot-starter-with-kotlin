package com.example.demo.controller

import com.example.demo.common.API_VERSION_PREFIX
import com.example.demo.common.apiOK
import com.example.demo.model.Menu
import com.example.demo.service.MenuService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("$API_VERSION_PREFIX/menus")
class MenuController(
        private val menuService: MenuService
) {

    @GetMapping("/{id}")
    fun getMenu(@PathVariable id: Int): ResponseEntity<Menu?> {
        return apiOK(menuService.findByIdOrNull(id)?: throw EntityNotFoundException())
    }

    @GetMapping
    fun getMenus(): ResponseEntity<MutableList<Menu>?> {
        return ResponseEntity.ok(menuService.findAll())
    }
}