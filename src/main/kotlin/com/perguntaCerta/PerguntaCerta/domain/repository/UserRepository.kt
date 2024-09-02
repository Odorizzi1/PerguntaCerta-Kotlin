package com.perguntaCerta.PerguntaCerta.domain.repository

import com.perguntaCerta.PerguntaCerta.domain.model.UserModel
import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<UserModel,Int>{


}