package modelo.jogador

import modelo.plano.PlanoEntity
import modelo.plano.PlanoPadraoEntity
import javax.persistence.*

@Entity
@Table(name = "jogadores")
data class JogadorEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val nome: String = "",
    val email: String = "",
    val dataNascimento:String? = null,
    val usuario:String? = null,
    @ManyToOne
    val plano: PlanoEntity = PlanoPadraoEntity())