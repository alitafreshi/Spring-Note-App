package com.alitafreshi.note_app.note.service

import com.alitafreshi.note_app.exception_manager.model.BaseAppException
import com.alitafreshi.note_app.model.BaseResponse
import com.alitafreshi.note_app.model.ResponseStatus
import com.alitafreshi.note_app.note.model.Note
import com.alitafreshi.note_app.note.repository.NoteRepository
import com.alitafreshi.note_app.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository, private val userRepository: UserRepository) {
    fun getAllNotesByUserId(userId: Long): BaseResponse<List<Note>> = BaseResponse(response = noteRepository.findByUserId(userId = userId), status = ResponseStatus(code = HttpStatus.OK.value(), description = HttpStatus.OK.name))

    fun insertNewNote(newNote: Note): BaseResponse<Note> {
        val user = userRepository.findById(newNote.user.userId).orElseThrow { BaseAppException(errorCode = HttpStatus.NOT_FOUND, errorMessage = "there is no user with this id in the database") }
        val note = Note(
                noteId = 0,
                title = newNote.title,
                description = newNote.description,
                date = newNote.date,
                user = user
        )
        noteRepository.save(note)
        return BaseResponse(response = note, status = ResponseStatus(code = HttpStatus.CREATED.value(), description = HttpStatus.CREATED.name))
    }

    fun updateNoteById(id: Long, updatedNote: Note): BaseResponse<Note> {
        val existingNote = noteRepository.findById(id).orElseThrow { BaseAppException(errorCode = HttpStatus.NOT_FOUND, errorMessage = "there is no note with this id in the database") }
        val newNote = existingNote.copy(title = updatedNote.title, description = updatedNote.description, date = updatedNote.date)
        noteRepository.save(newNote)

        return BaseResponse(response = newNote, status = ResponseStatus(code = HttpStatus.OK.value(), description = HttpStatus.OK.name))
    }

    fun deleteNoteByNoteId(noteId: Long): BaseResponse<String> {
        noteRepository.findById(noteId).orElseThrow { BaseAppException(errorCode = HttpStatus.NOT_FOUND, errorMessage = "there is no note with this id in the database") }
        noteRepository.deleteById(noteId)
        return BaseResponse(response = "note deleted successfully", status = ResponseStatus(code = HttpStatus.OK.value(), description = HttpStatus.OK.name))
    }


}