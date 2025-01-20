package modelo.plano

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Inheritance
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val tipo: TiposPlano = TiposPlano.BRONZE)

@Entity
@DiscriminatorValue("PADRÃO")
class PlanoPadraoEntity(id: Int = 0): PlanoEntity(id, TiposPlano.BRONZE)

@Entity
@DiscriminatorValue("ASSINATURA")
class PlanoAssinaturaEntity(
    id: Int = 0,
    tipo: TiposPlano = TiposPlano.PRATA,
    val mensalidade: BigDecimal = BigDecimal.ZERO,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: BigDecimal = BigDecimal.ZERO): PlanoEntity(id, tipo)