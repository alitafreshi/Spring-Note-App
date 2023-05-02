package com.alitafreshi.note_app

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(title = "Note App Apis", description = "An Collection of apis for note app", version = "1.0"))
class NoteAppApplication {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<NoteAppApplication>(*args)
		}
	}
}
