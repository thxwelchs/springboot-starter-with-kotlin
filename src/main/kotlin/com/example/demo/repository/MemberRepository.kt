package com.example.demo.repository

import com.example.demo.model.Member

interface MemberRepository : BaseEntityRepository<Member, Int> {
    fun findByMemberIdAndPassword(memberId: String, password: String)
}