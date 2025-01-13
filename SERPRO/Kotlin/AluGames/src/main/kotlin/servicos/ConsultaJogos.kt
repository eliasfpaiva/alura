package servicos

import modelo.jogo.Jogo
import java.util.*

class ConsultaJogos{
    fun consultaPorId(){
        print("Informe o id do jogo desejado: ")
        val leitura = Scanner(System.`in`)
        val id = leitura.nextLine()

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            val meuInfoJogo = ConsumoApi().buscarJogoByID(id)
            meuJogo = Jogo(
                meuInfoJogo.info.title,
                meuInfoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("O Jogo é: ${meuJogo?.titulo}")
            println("Se desejar inserir uma descrição personalizada digite 's': ")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizado para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            println(meuJogo)
        }

        resultado.onSuccess {
            println("Busca finalizada com sucesso.")
        }
    }
}