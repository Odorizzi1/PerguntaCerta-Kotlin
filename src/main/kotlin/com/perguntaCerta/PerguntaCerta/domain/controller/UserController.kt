package com.perguntaCerta.PerguntaCerta.domain.controller

import com.perguntaCerta.PerguntaCerta.Application.Services.UserService
import com.perguntaCerta.PerguntaCerta.domain.model.UserModel
import com.perguntaCerta.PerguntaCerta.exception.UserCreationException
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {
    @PostMapping
    fun create(@Valid @RequestBody user: UserModel) {
       try {
        return userService.createUser(user)

       }catch (e:Exception){
           throw UserCreationException("Erro ao criar o usuário: ${e.message}")
       }
    }
}