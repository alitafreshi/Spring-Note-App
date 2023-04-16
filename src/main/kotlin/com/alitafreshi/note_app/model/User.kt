package com.alitafreshi.note_app.model

import jakarta.persistence.*

@Table(name = "tbl_user", uniqueConstraints = [
    UniqueConstraint(name = "user_phone_number_unique", columnNames = ["phone_number"])
])
@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        val userId: Long,

        @Column(name = "phone_number", nullable = false)
        val phoneNumber: String
)
