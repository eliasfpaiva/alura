package servicos

import Utils.toJogador
import Utils.toJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import modelo.jogador.InfoJogadorJson
import modelo.jogador.Jogador
import modelo.jogo.InfoJogo
import modelo.jogo.InfoJogoJson
import modelo.jogo.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object ConsumoApi {
    fun buscarJogoByID(id: String?): InfoJogo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
        return Gson().fromJson(consomeDados(url), InfoJogo::class.java)
    }

    fun buscaJogadores(): List<Jogador> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val tipo = object : TypeToken<List<InfoJogadorJson>>() {}.type

        return Gson()
            .fromJson<List<InfoJogadorJson>>(consomeDados(url), tipo)
            .map { info -> info.toJogador() }
    }

    fun buscaJogos(): List<Jogo> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val tipo = object : TypeToken<List<InfoJogoJson>>() {}.type

        return Gson()
            .fromJson<List<InfoJogoJson>>(consomeDados(url), tipo)
            .map { info -> info.toJogo() }
    }

    private fun consomeDados(url: String): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }
}