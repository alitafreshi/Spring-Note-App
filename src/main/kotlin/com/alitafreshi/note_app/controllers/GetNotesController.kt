package com.alitafreshi.note_app.controllers

import com.alitafreshi.note_app.service.NoteService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/noteList")
class NoteController(private val noteService: NoteService) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/userId")
    fun getAllNotes(): String = noteService.getAllNotes()

}