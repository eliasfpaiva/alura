package servicos

import com.google.gson.Gson
import modelo.jogo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscarJogoByID(id: String?): InfoJogo {
        val client: HttpClient = HttpClient.newHttpClient()
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val gson = Gson()
        return gson.fromJson(response.body(), InfoJogo::class.java)
    }
}