package modelo.jogo

import dados.DAO
import javax.persistence.EntityManager

class JogoDAO(override val manager: EntityManager) : DAO<Jogo, JogoEntity>{
    override val classe = JogoEntity::class.java
    override fun converterDeEntidade(entidade: JogoEntity) = entidade.paraJogo()
    override fun converterEmEntidade(objeto: Jogo) = objeto.paraEntidade()
}