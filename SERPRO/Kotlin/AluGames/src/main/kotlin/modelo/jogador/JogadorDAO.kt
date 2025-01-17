package modelo.jogador

import dados.Banco
import dados.DAO
import javax.persistence.EntityManager

class JogadorDAO : DAO<Jogador, JogadorEntity> {
    override val manager: EntityManager = Banco.getEntityManager()
    override val classe = JogadorEntity::class.java
    override val nomeEntidade = "JogadorEntity"
    override fun converterDeEntidade(entidade: JogadorEntity) = entidade.paraJogador()
    override fun converterEmEntidade(objeto: Jogador) = JogadorEntity.doJogador(objeto)
}