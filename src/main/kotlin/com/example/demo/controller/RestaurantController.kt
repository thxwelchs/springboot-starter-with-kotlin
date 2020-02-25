package com.example.demo.controller

import com.example.demo.common.API_VERSION_PREFIX
import com.example.demo.common.apiOK
import com.example.demo.model.Restaurant
import com.example.demo.service.RestaurantService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("$API_VERSION_PREFIX/restaurants")
class RestaurantController(
        val restaurantService: RestaurantService
) : BaseAPIController<Restaurant, Int, RestaurantService>() {

}