package modelo.jogador

import dados.DAO
import javax.persistence.EntityManager

class JogadorDAO(override val manager: EntityManager) : DAO<Jogador, JogadorEntity> {
    override val classe = JogadorEntity::class.java
    override fun converterDeEntidade(entidade: JogadorEntity) = entidade.paraJogador()
    override fun converterEmEntidade(objeto: Jogador)= objeto.paraEntidade()
}