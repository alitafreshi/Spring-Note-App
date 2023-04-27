package com.alitafreshi.note_app.user.controllers

import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.user.model.User
import com.alitafreshi.note_app.user.service.UserService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping("{userPhoneNumber}")
    fun getUserInfo(@PathVariable("userPhoneNumber") phoneNumber: String): BaseResponse<User> = userService.getUserInfo(phoneNumber = phoneNumber)

    @PostMapping("/newUser")
    fun insertNewUser(@RequestBody user: User): BaseResponse<User> = userService.createUserIfNotExists(user)

    @DeleteMapping("/deleteUser")
    @Transactional
    fun deleteUser(@RequestParam userPhoneNumber: String): BaseResponse<String> = userService.removeUser(phoneNumber = userPhoneNumber)

}