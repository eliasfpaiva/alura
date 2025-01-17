package dados

import javax.persistence.Persistence

object Banco {
    fun getEntityManager() = Persistence.createEntityManagerFactory("alugames").createEntityManager()
}