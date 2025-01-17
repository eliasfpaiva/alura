package modelo.jogo

import dados.Banco
import dados.DAO

class JogoDAO() : DAO<Jogo, JogoEntity>{
    override val manager = Banco.getEntityManager()
    override val classe = JogoEntity::class.java
    override fun converterDeEntidade(entidade: JogoEntity) = entidade.paraJogo()
    override fun converterEmEntidade(objeto: Jogo) = JogoEntity.doJogo(objeto)
}