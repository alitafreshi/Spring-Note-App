package com.alitafreshi.note_app.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "tbl_note")
@Entity
data class Note(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(nullable = false, columnDefinition = "TEXT")
        val title: String,

        @Column(nullable = false, columnDefinition = "TEXT")
        val description: String,

        @Column(nullable = false, columnDefinition = "TEXT")
        val date: String,

        @Column(nullable = false, columnDefinition = "TEXT")
        val color: Int,

        @Column(nullable = false)
        val userId: Int
)
