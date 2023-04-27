package com.alitafreshi.note_app.user.model

import com.alitafreshi.note_app.note.model.Note
import jakarta.persistence.*

@Table(name = "tbl_user", uniqueConstraints = [
    UniqueConstraint(name = "user_phone_number_unique", columnNames = ["phone_number"]),
    UniqueConstraint(name = "user_id_unique", columnNames = ["user_id"])
])
@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        val userId: Long,

        @Column(name = "phone_number", nullable = false)
        val phoneNumber: String,

        @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE], orphanRemoval = true)
        val notes: MutableList<Note> = mutableListOf()
)
