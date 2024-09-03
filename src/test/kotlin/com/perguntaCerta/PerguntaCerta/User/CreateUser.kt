package com.perguntaCerta.PerguntaCerta

import com.perguntaCerta.PerguntaCerta.Application.Services.UserService
import com.perguntaCerta.PerguntaCerta.domain.model.UserModel
import com.perguntaCerta.PerguntaCerta.domain.repository.UserRepository
import io.kotest.core.spec.style.FunSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify


class CreateUserTest: FunSpec({
    val userRepository = mockk<UserRepository>(relaxed = true)
    val userService = UserService(userRepository)

    test("Should create user "){
        val user = UserModel(name = "Test User", email = "test@example.com")

        every { userRepository.save(user) } returns user

        userService.createUser(user)

        verify(exactly = 1) { userRepository.save(user) }
    }
}
)
