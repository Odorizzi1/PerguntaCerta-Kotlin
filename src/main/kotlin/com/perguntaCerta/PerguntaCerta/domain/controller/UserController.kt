package com.perguntaCerta.PerguntaCerta.domain.controller

import com.perguntaCerta.PerguntaCerta.domain.controller.contracts.IUserController
import com.perguntaCerta.PerguntaCerta.domain.model.UserInfoModel
import com.perguntaCerta.PerguntaCerta.domain.model.UserModel
import com.perguntaCerta.PerguntaCerta.domain.repository.UserInfoRepository
import com.perguntaCerta.PerguntaCerta.domain.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder,
    val userInfoRepository: UserInfoRepository
) : IUserController {
    @Transactional
    @PostMapping("/create")
    override fun create(@RequestBody userModel: UserModel) {
        userModel.password = passwordEncoder.encode(userModel.password)
        userRepository.save(userModel)
    }

    @GetMapping("/list/{id}")
    override fun listUser(@PathVariable id: Int): UserModel {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("Usuário não encontrado") }
    }

    @Transactional
    @PostMapping("/userinfo")
    override fun createUserInfo(@RequestBody userInfoModel: UserInfoModel) :UserInfoModel {
      return  userInfoRepository.save(userInfoModel)
    }

    @GetMapping("/userinfo")
    override fun getUserInfo(@RequestParam userId: Int): ResponseEntity<UserInfoModel> {
        return try {
            val userInfo = userInfoRepository.findByUserId(userId)
            if (userInfo != null) {
                ResponseEntity.ok(userInfo)
            } else {
                ResponseEntity.notFound().build()
            }
        } catch (ex: Exception) {
            println("Erro ao buscar UserInfo: ${ex.message}")
            ResponseEntity.internalServerError().build()
        }
    }

}