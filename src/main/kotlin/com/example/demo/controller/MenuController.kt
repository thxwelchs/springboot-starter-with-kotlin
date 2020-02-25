package com.example.demo.controller

import com.example.demo.common.API_VERSION_PREFIX
import com.example.demo.common.apiOK
import com.example.demo.model.Menu
import com.example.demo.service.MenuService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("$API_VERSION_PREFIX/menus")
class MenuController(
        private val menuService: MenuService
) : BaseAPIController<Menu, Int, MenuService>() {

    @GetMapping("/test")
    fun asdf(@DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss") start: LocalDateTime,@DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")  end: LocalDateTime): ResponseEntity<MutableList<Menu>?> {
        return apiOK(menuService.findByCreatedAtBetween(start, end))
    }

}