package modelo.plano

import dados.DAO
import javax.persistence.EntityManager

class PlanoDAO(override val manager: EntityManager) : DAO<Plano, PlanoEntity> {
    override val classe = PlanoEntity::class.java
    override fun converterDeEntidade(entidade: PlanoEntity) = entidade.paraPlano()
    override fun converterEmEntidade(objeto: Plano) = objeto.paraEntidade()
}