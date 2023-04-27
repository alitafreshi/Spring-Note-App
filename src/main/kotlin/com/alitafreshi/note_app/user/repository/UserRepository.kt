package com.alitafreshi.note_app.user.repository

import com.alitafreshi.note_app.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByPhoneNumber(phoneNumber: String):User
    fun existsByPhoneNumber(phoneNumber: String):Boolean
    fun deleteByPhoneNumber(phoneNumber: String):Int

}