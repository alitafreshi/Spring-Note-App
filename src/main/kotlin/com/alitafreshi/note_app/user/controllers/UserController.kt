package com.alitafreshi.note_app.user.controllers

import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.user.model.User
import com.alitafreshi.note_app.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @PostMapping("/newUser")
    fun insertNewUser(@RequestBody user: User): BaseResponse<User> = userService.createUserIfNotExists(user)

}