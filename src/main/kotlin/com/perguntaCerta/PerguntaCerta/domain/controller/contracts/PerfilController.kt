package com.perguntaCerta.PerguntaCerta.domain.controller.contracts

import com.perguntaCerta.PerguntaCerta.domain.repository.UserRepository
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
class PerfilController(
    private val userRepository: UserRepository
) {

    @GetMapping("/perfil")
    fun getPerfilInfo(@AuthenticationPrincipal jwt: Jwt): ResponseEntity<String> {
        val userId = jwt.subject.toInt()
        val user = userRepository.findById(userId).orElseThrow { IllegalArgumentException("User not found") }
        return ResponseEntity.ok(user.email)
    }
}
