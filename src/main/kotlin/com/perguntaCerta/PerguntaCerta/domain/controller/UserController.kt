package com.perguntaCerta.PerguntaCerta.domain.controller

import com.perguntaCerta.PerguntaCerta.domain.controller.contracts.IUserController
import com.perguntaCerta.PerguntaCerta.domain.model.UserInfoModel
import com.perguntaCerta.PerguntaCerta.domain.model.UserModel
import com.perguntaCerta.PerguntaCerta.domain.repository.UserInfoRepository
import com.perguntaCerta.PerguntaCerta.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
    val userInfoRepository: UserInfoRepository
) : IUserController {

    @PostMapping("/create")
    override fun create(@RequestBody userModel: UserModel) {
        userModel.password = passwordEncoder.encode(userModel.password)
        userRepository.save(userModel)
    }

    @GetMapping("/list/{id}")
    override fun listUser(@PathVariable id: Int): UserModel {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("Usuário não encontrado") }
    }

    @PostMapping("/userinfo")
    override fun createUserInfo(@RequestBody userInfoModel: UserInfoModel) :UserInfoModel {
      return  userInfoRepository.save(userInfoModel)
    }

    @GetMapping("/userinfo")
    fun getUserInfo(@RequestParam userId: Int): UserInfoModel {
        return userInfoRepository.findByUserId(userId)
    }

}