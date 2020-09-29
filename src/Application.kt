package com.example

import gov.nasa.worldwind.avlist.AVKey
import gov.nasa.worldwind.geom.coords.UTMCoord
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        post("/") {
            val req = call.receive<Recieve>()
            val res = UTMCoord.locationFromUTMCoord(37, AVKey.NORTH, req.x, req.y)
            call.respond(res)
        }

    }
}

data class Recieve(val x: Double, val y: Double)

