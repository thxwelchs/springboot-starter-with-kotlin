package com.example.demo.repository

import com.example.demo.model.Restaurant
import org.springframework.data.jpa.repository.JpaRepository

interface RestaurantRepository: BaseEntityRepository<Restaurant, Int>