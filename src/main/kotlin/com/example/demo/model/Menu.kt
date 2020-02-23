package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
data class Menu(
        @ManyToOne(fetch = FetchType.LAZY)
        var restaurant: Restaurant,
        var price: BigDecimal = BigDecimal.ZERO,
        var name: String = ""
): MutableEntity()