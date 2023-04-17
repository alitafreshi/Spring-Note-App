package com.alitafreshi.note_app.user.service

import com.alitafreshi.note_app.exception_manager.model.BaseAppException
import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.model.ResponseStatus
import com.alitafreshi.note_app.user.model.User
import com.alitafreshi.note_app.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    /* fun createUserIfNotExists(user: User) {
         if (!userRepository.existsByPhoneNumber(user.phoneNumber)) {
             userRepository.save(user)
             return
         }
         throw BaseAppException(errorCode = HttpStatus.NOT_ACCEPTABLE, errorMessage = "user is exist with this phone number")
     }*/


    fun createUserIfNotExists(user: User): BaseResponse<User> {
        if (!userRepository.existsByPhoneNumber(user.phoneNumber)) {
            userRepository.save(user)
            return BaseResponse(response = user, status = ResponseStatus(code = HttpStatus.CREATED.value(), description = HttpStatus.CREATED.name))
        }
        throw BaseAppException(errorCode = HttpStatus.NOT_ACCEPTABLE, errorMessage = "user is exist with this phone number")
    }

}