package com.perguntaCerta.PerguntaCerta.domain.controller.contracts

import com.perguntaCerta.PerguntaCerta.domain.model.UserModel

interface IUserController {

   fun  create(userModel: UserModel)

   fun listUser(id:Int):UserModel
}