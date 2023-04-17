package com.alitafreshi.note_app.note.service

import com.alitafreshi.note_app.note.model.Note
import com.alitafreshi.note_app.note.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {
    fun getAllNotes(): List<Note> = noteRepository.findAll()
}