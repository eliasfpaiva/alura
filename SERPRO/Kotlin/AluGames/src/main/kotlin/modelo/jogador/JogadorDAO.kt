package modelo.jogador

import dados.Banco
import dados.DAO
import javax.persistence.EntityManager

object JogadorDAO : DAO<Jogador, JogadorEntity> {
    override val manager: EntityManager = Banco.getEntityManager()
    override val classe = JogadorEntity::class.java
    override fun converterDeEntidade(entidade: JogadorEntity) = entidade.paraJogador()
    override fun converterEmEntidade(objeto: Jogador) = JogadorEntity.doJogador(objeto)
}