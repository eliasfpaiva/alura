package dados

import javax.persistence.EntityManager

interface DAO<T, E> {
    val manager: EntityManager
    val classe: Class<E>
    val nomeEntidade: String
    fun converterDeEntidade(entidade: E): T
    fun converterEmEntidade(objeto: T): E

    fun listar(): List<T> {
        return manager
            .createQuery("FROM $nomeEntidade", classe)
            .resultList.map { converterDeEntidade(it) }
    }

    fun salvar(item: T) {
        manager.transaction.begin()
        manager.persist(converterEmEntidade(item))
        manager.transaction.commit()
    }
}