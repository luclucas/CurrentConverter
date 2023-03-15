package com.lulu.currentconverter.http

import com.lulu.currentconverter.api.Endpoint
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class Requisicao {

    suspend fun getDados(): Map<String, String> {
        val client = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.get(Endpoint.CAMINHO)
        return response.body()
    }
}