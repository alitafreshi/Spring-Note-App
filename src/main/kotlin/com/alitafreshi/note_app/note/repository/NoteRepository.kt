package com.alitafreshi.note_app.note.repository

import com.alitafreshi.note_app.note.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Long>