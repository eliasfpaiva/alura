package servicos

import modelo.jogo.Jogo
import java.util.*

class ConsultaJogos{
    companion object {
        fun consultaPorId(leitura:Scanner, id:String = solicitarId(leitura)): Jogo? {

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
            return meuJogo
        }

        private fun solicitarId(leitura:Scanner): String {
            print("Informe o id do jogo desejado: ")
            return leitura.nextLine()
        }
    }
}