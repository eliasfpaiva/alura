package dados

import javax.persistence.EntityManager

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

    fun salvar(item: TModelo) {
        manager.transaction.begin()
        manager.persist(converterEmEntidade(item))
        manager.transaction.commit()
    }
}