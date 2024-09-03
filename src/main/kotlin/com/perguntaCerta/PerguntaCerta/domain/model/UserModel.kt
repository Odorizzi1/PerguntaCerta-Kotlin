package com.perguntaCerta.PerguntaCerta.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@Entity(name = "user")
data class UserModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotBlank(message = "Name is mandatory")
    val name: String,

    @field:Email
    @Column(unique = true)
    val email: String
) {

    constructor() : this(id = null, name = "", email = "")
}
//teste commit teste commit
