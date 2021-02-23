package de.heilsen.randomizer.web

import de.heilsen.randomizer.ListRandomizer.concatRandom
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.lang.System.lineSeparator

fun main() {
    embeddedServer(Netty, 8000) {
        routing {
            get("/") {
                with(call.request.queryParameters) {
                    val input = get("input")?.split(",") ?: emptyList()
                    val number = get("number")?.toInt() ?: 1

                    val output = input.concatRandom(
                        number = number,
                        sorted = true,
                        separator = lineSeparator()
                    )

                    call.respondText(output)
                }
            }
        }
    }.start(wait = true)
}