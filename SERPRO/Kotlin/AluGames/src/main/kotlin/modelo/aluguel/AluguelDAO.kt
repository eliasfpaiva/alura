package modelo.aluguel

import dados.DAO
import javax.persistence.EntityManager

class AluguelDAO(override val manager: EntityManager) : DAO<Aluguel, AluguelEntity> {
    override val classe = AluguelEntity::class.java
    override fun converterDeEntidade(entidade: AluguelEntity) = entidade.paraAluguel()
    override fun converterEmEntidade(objeto: Aluguel) = objeto.paraEntidade()
}