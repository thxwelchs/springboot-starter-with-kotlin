package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OrderBy

@Entity
class Restaurant(
        var name: String = "",
        @OneToMany(mappedBy = "restaurant")
        @OrderBy("name asc")
        var menus: MutableSet<Menu> = TreeSet()
): MutableEntity() {

        internal fun addMenu(menu: Menu) {
                menus.add(menu)
                menu.restaurant = this
        }
}