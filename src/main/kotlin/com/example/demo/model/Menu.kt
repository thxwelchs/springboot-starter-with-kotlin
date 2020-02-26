package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
@JsonIgnoreProperties(value=["hibernateLazyInitializer", "handler"])
class Menu(
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "restaurant_id")
        var restaurant: Restaurant,
        var price: BigDecimal = BigDecimal.ZERO,
        var name: String = ""
): MutableEntity()