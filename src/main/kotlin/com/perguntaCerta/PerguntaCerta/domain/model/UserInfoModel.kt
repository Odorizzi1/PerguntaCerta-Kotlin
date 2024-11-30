package com.perguntaCerta.PerguntaCerta.domain.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity(name = "user_info")
data class UserInfoModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotBlank(message = "First name is mandatory")
    val firstname: String,

    var lastname: String = "",

    @Column(name = "user_id", nullable = false)
    val userId: Int
){
    constructor() : this(null, "", "", 0)
}

