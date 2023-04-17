package com.alitafreshi.note_app.user.service

import com.alitafreshi.note_app.user.model.User
import com.alitafreshi.note_app.user.repository.UserRepository
import com.sun.nio.sctp.IllegalReceiveException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUserIfNotExists(user: User) {
        if (!userRepository.existsByPhoneNumber(user.phoneNumber)) {
            userRepository.save(user)
            return
        }
        throw IllegalStateException("user is exist with this phone number")
    }

}