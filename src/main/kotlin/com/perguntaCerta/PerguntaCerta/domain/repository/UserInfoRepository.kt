package com.perguntaCerta.PerguntaCerta.domain.repository

import com.perguntaCerta.PerguntaCerta.domain.model.UserInfoModel

import org.springframework.data.repository.CrudRepository


interface UserInfoRepository : CrudRepository<UserInfoModel,Int>{

    fun findByUserId(userId: Int): UserInfoModel


}