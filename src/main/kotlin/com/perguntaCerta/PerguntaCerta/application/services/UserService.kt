package com.perguntaCerta.PerguntaCerta.Application.Services


import com.perguntaCerta.PerguntaCerta.domain.model.UserModel
import com.perguntaCerta.PerguntaCerta.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository
) {

    fun createUser(user:UserModel){
       this.userRepository.save(user)
    }
}