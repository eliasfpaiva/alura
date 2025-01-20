package dados

import javax.persistence.EntityManager
import javax.persistence.NoResultException

interface DAO<TModelo, TEntidade> {
    val manager: EntityManager
    val classe: Class<TEntidade>
    fun converterDeEntidade(entidade: TEntidade): TModelo
    fun converterEmEntidade(objeto: TModelo): TEntidade

    fun listar(): List<TModelo> {
        return manager
            .createQuery("FROM ${classe.simpleName}", classe)
            .resultList.map { converterDeEntidade(it) }
    }

    fun recuperarPeloId(id: Int) = converterDeEntidade(recuperaEntidadePeloId(id))

    fun apagarPeloId(id: Int) {
        manager.transaction.begin()
        manager.remove(recuperaEntidadePeloId(id))
        manager.transaction.commit()
    }

    fun recuperaEntidadePeloId(id: Int): TEntidade {
        val query = manager.createQuery("FROM ${classe.simpleName} WHERE id=:id", classe)
        query.setParameter("id", id)
        return query.singleResult
    }

    fun salvar(item: TModelo) {
        manager.transaction.begin()
        manager.persist(converterEmEntidade(item))
        manager.transaction.commit()
    }
}