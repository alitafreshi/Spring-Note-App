package com.alitafreshi.note_app.note.controllers

import com.alitafreshi.note_app.exception_manager.model.BaseErrorResponse
import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.note.model.Note
import com.alitafreshi.note_app.note.service.NoteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.transaction.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/note")
@Tag(name = "Note Api")
class NoteController(private val noteService: NoteService) {

    @GetMapping("/noteList/{userId}")
    @Operation(summary = "get all related notes for specific user by userId")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "retrieve note successfully", content = arrayOf(Content(mediaType = "application/json", schema = Schema(implementation = Note::class)))),

        ApiResponse(responseCode = "400", description = "Bad request", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))])
    ])
    fun getAllNotesByUserId(@PathVariable("userId") userId: Long): BaseResponse<List<Note>> = noteService.getAllNotesByUserId(userId = userId)



    @PostMapping("/newNote")
    @Operation(summary = "insert new note into database")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "retrieve note successfully", content = arrayOf(Content(mediaType = "application/json", schema = Schema(implementation = Note::class)))),

        ApiResponse(responseCode = "400", description = "Bad request", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "404", description = "Not Found", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))])
    ])
    fun insertNewNote(@RequestBody newNote: Note): BaseResponse<Note> = noteService.insertNewNote(newNote = newNote)

    @PostMapping("/updateNote/{noteId}")
    @Operation(summary = "update an existing note into database")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "update note successfully", content = arrayOf(Content(mediaType = "application/json", schema = Schema(implementation = Note::class)))),

        ApiResponse(responseCode = "400", description = "Bad request", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "404", description = "Not Found", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))])
    ])
    fun updateNote(@PathVariable("noteId") noteId: Long, @RequestBody newNote: Note): BaseResponse<Note> = noteService.updateNoteById(id = noteId, updatedNote = newNote)

    @DeleteMapping("/deleteNote/{noteId}")
    @Transactional
    @Operation(summary = "delete note from database")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "remove note successfully", content = arrayOf(Content(mediaType = "application/json", schema = Schema(implementation = Note::class)))),

        ApiResponse(responseCode = "400", description = "Bad request", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "404", description = "Not Found", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))]),

        ApiResponse(responseCode = "500", description = "Internal server error", content = [Content(mediaType = "application/json", schema = Schema(implementation = BaseErrorResponse::class))])
    ])
    fun deleteNoteById(@PathVariable("noteId") noteId: Long): BaseResponse<String> = noteService.deleteNoteByNoteId(noteId = noteId)

}