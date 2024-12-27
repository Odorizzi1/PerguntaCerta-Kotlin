package com.perguntaCerta.PerguntaCerta.domain.controller

import com.perguntaCerta.PerguntaCerta.domain.repository.UserRepository
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import java.time.Instant


@RestController
class TokenController(
    private val jwtEncoder: JwtEncoder,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
        val user = userRepository.findByName(loginRequest.userName)

        if (user == null) {
            throw BadCredentialsException("User not found!")
        }

        if (!passwordEncoder.matches(loginRequest.password, user.password)) {
            throw BadCredentialsException("Password is invalid!")
        }

        val now = Instant.now()
        val expiresIn = 86400L

        val claims = JwtClaimsSet.builder()
            .issuer("mybackend")
            .subject(user.id.toString())
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiresIn))
            .build()

        val jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue

        return ResponseEntity.ok(LoginResponse(jwtValue, expiresIn, user.id))
    }

    data class LoginRequest(
        val userName: String,
        val password: String,
    )

    data class LoginResponse(
        val jwt: String,
        val expiresIn: Long,
        val userId: Int?
    )
}
