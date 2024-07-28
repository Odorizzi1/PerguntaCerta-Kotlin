package com.perguntaCerta.PerguntaCerta.Domain.controller

import com.perguntaCerta.PerguntaCerta.Application.Services.UserService
import com.perguntaCerta.PerguntaCerta.Domain.Model.UserModel
import com.perguntaCerta.PerguntaCerta.exception.UserCreationException
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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