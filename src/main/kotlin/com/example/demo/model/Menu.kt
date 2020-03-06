package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@JsonIdentityInfo(generator = IntSequenceGenerator::class, property = "id")
class Menu(
        var name: String = "",
        var price: BigDecimal = BigDecimal.ZERO,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "restaurant_id")
        var restaurant: Restaurant
): MutableEntity()