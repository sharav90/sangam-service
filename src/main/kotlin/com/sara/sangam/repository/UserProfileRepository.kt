package com.sara.sangam.repository

import com.sara.sangam.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProfileRepository : JpaRepository<UserProfile, Int> {

    fun findByUserId(userId: Int): UserProfile

    fun deleteByUserId(userId: Int): Unit
}