package com.alitafreshi.note_app.model

import com.alitafreshi.note_app.user.model.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

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

        @Column(nullable = false, columnDefinition = "TEXT")
        val color: Int,

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
        val user: User
)
