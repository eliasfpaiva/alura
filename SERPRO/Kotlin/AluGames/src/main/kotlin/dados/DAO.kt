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

    fun recuperarPeloId(id: Int): TModelo? {
        val query = manager.createQuery("FROM ${classe.simpleName} WHERE id=:id", classe)
        query.setParameter("id", id)
        try {
            return converterDeEntidade(query.singleResult)
        }catch (e: NoResultException){
            return null
        }
    }

    fun apagarPeloId(id: Int) {
        val query = manager.createQuery("FROM ${classe.simpleName} WHERE id=:id", classe)
        query.setParameter("id", id)

        manager.transaction.begin()
        manager.remove(query.singleResult)
        manager.transaction.commit()
    }

    fun salvar(item: TModelo) {
        manager.transaction.begin()
        manager.persist(converterEmEntidade(item))
        manager.transaction.commit()
    }
}