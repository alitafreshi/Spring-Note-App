package com.alitafreshi.note_app.repository

import com.alitafreshi.note_app.model.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long> {
}