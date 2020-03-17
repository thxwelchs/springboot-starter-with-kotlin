package com.example.demo.model

import com.example.demo.model.entity.MutableEntity
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Member(
        var memberId: String = "",
        var name: String = "",
        var password: String = "",
        @Enumerated(EnumType.STRING)
        var memberRole: MemberRole
): MutableEntity()

enum class MemberRole() {
        ADMIN, MANAGER, PARTNER, USER
}