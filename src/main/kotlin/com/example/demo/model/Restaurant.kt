package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OrderBy

@Entity
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "id")
class Restaurant(
        var name: String = "",
        @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
        @OrderBy("name asc")
        var menus: MutableSet<Menu> = TreeSet()
): MutableEntity() {

        fun addMenu(menu: Menu) {
                menus.add(menu)
                menu.restaurant = this
        }
}