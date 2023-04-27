package com.alitafreshi.note_app.note.model

import com.alitafreshi.note_app.user.model.User
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Table(name = "tbl_note")
@Entity
data class Note(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "note_id")
        val noteId: Long,

        @Column(nullable = false, columnDefinition = "TEXT")
        val title: String,

        @Column(nullable = false, columnDefinition = "TEXT")
        val description: String,

        @Column(nullable = false, columnDefinition = "TEXT")
        val date: String,

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
        @JsonIgnoreProperties("notes")
        val user: User
)
