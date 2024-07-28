package com.perguntaCerta.PerguntaCerta

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PerguntaCertaApplication

fun main(args: Array<String>) {
	val dotenv = dotenv()
	println(dotenv["MYAPP_SOMEVALUE"])
	runApplication<PerguntaCertaApplication>(*args)
}
