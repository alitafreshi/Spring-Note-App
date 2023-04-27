package com.alitafreshi.note_app.note.controllers

import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.note.model.Note
import com.alitafreshi.note_app.note.service.NoteService
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/note")
class NoteController(private val noteService: NoteService) {

    @GetMapping("/noteList/{userId}")
    fun getAllNotesByUserId(@PathVariable("userId") userId: Long): BaseResponse<List<Note>> = noteService.getAllNotesByUserId(userId = userId)

    @PostMapping("/newNote")
    fun insertNewNote(@RequestBody newNote: Note): BaseResponse<Note> = noteService.insertNewNote(newNote = newNote)

    @PostMapping("/updateNote/{noteId}")
    fun updateNote(@PathVariable("noteId") noteId: Long, @RequestBody newNote: Note): BaseResponse<Note> = noteService.updateNoteById(id = noteId, updatedNote = newNote)

    @DeleteMapping("/deleteNote/{noteId}")
    @Transactional
    fun deleteNoteById(@PathVariable("noteId") noteId: Long): BaseResponse<String> = noteService.deleteNoteByNoteId(noteId = noteId)

}