package com.alitafreshi.note_app.model

import jakarta.persistence.*

@Table(name = "tbl_user", uniqueConstraints = [
    UniqueConstraint(name = "user_phone_number_unique", columnNames = ["phone_number"])
])
@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "phone_number", nullable = false)
        val phoneNumber: String
)
