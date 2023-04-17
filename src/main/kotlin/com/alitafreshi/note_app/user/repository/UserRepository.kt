package com.alitafreshi.note_app.user.repository

import com.alitafreshi.note_app.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun existsByPhoneNumber(phoneNumber: String):Boolean
}