package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import javax.persistence.Entity

@Entity
data class Restaurant(
        var name: String = ""
): MutableEntity()