package com.alitafreshi.note_app.user.controllers

import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.user.model.User
import com.alitafreshi.note_app.user.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users Api")
class UserController(private val userService: UserService) {

    @GetMapping("{userPhoneNumber}")
    @Operation(summary = "retrieve user info by user phone number")
    fun getUserInfo(@PathVariable("userPhoneNumber") phoneNumber: String): BaseResponse<User> = userService.getUserInfo(phoneNumber = phoneNumber)

    @PostMapping("/newUser")
    @Operation(summary = "insert new user into database")
    fun insertNewUser(@RequestBody user: User): BaseResponse<User> = userService.createUserIfNotExists(user)

    @DeleteMapping("/deleteUser")
    @Transactional
    @Operation(summary = "remove user from database with phone number")
    fun deleteUser(@RequestParam userPhoneNumber: String): BaseResponse<String> = userService.removeUser(phoneNumber = userPhoneNumber)

}