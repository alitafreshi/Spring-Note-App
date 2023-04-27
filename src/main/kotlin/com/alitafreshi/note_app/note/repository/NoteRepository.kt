package com.alitafreshi.note_app.note.repository

import com.alitafreshi.note_app.note.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Long> {
    @Query("SELECT n FROM Note n WHERE n.user.userId = :userId")
    fun findByUserId(@Param("userId") userId: Long): List<Note>
}