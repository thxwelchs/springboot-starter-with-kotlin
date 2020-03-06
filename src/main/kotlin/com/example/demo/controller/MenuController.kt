package com.example.demo.controller

import com.example.demo.common.API_VERSION_PREFIX
import com.example.demo.model.Menu
import com.example.demo.service.MenuService
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
) : BaseAPIController<Menu, Int, MenuService>() {

    @GetMapping("/{id}")
    override fun getOneByID(@PathVariable id: Int): ResponseEntity<Menu> {
        val m = menuService.findById(id).orElseThrow{EntityNotFoundException()}
        m.restaurant.name // lazy load
        return ResponseEntity.ok(m)
    }

}