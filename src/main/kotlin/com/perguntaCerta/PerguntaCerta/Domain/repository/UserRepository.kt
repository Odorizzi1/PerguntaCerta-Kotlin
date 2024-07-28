package com.perguntaCerta.PerguntaCerta.Domain.repository

import com.perguntaCerta.PerguntaCerta.Domain.Model.UserModel
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<UserModel,Int>{


}