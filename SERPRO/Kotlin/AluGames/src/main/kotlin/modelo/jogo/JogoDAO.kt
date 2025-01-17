package modelo.jogo

import dados.Banco
import dados.DAO
import javax.persistence.EntityManager

object JogoDAO : DAO<Jogo, JogoEntity>{
    override val manager: EntityManager = Banco.getEntityManager()
    override val classe = JogoEntity::class.java
    override fun converterDeEntidade(entidade: JogoEntity) = entidade.paraJogo()
    override fun converterEmEntidade(objeto: Jogo) = JogoEntity.doJogo(objeto)
}