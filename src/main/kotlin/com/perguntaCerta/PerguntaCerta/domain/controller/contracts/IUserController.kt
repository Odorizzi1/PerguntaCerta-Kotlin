package com.perguntaCerta.PerguntaCerta.domain.controller.contracts

import com.perguntaCerta.PerguntaCerta.domain.model.UserInfoModel
import com.perguntaCerta.PerguntaCerta.domain.model.UserModel

interface IUserController {

   fun  create(userModel: UserModel)

   fun listUser(id:Int):UserModel

   fun createUserInfo(userInfoModel: UserInfoModel):UserInfoModel

   fun getUserInfo(userId:Int): UserInfoModel
}