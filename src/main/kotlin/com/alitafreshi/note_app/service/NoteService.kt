package com.alitafreshi.note_app.service

import com.alitafreshi.note_app.model.Note
import com.alitafreshi.note_app.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {
    fun getAllNotes(): List<Note> = noteRepository.findAll()
}