package com.perguntaCerta.PerguntaCerta.Application.Services


import com.perguntaCerta.PerguntaCerta.Domain.Model.UserModel
import com.perguntaCerta.PerguntaCerta.Domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository
) {

    fun createUser(user:UserModel){
        println("Chamando2")
       this.userRepository.save(user)
    }
}