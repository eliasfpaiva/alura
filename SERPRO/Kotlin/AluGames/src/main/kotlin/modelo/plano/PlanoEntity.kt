package modelo.plano

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Inheritance
@Table(name = "planos")
@DiscriminatorColumn(name = "tipoEntidade", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Enumerated(EnumType.STRING)
    val tipo: TipoPlano = TipoPlano.BRONZE)

@Entity
@DiscriminatorValue("PADRÃO")
class PlanoPadraoEntity(id: Int = 0): PlanoEntity(id)

@Entity
@DiscriminatorValue("ASSINATURA")
class PlanoAssinaturaEntity(
    id: Int = 0,
    tipoPlano: TipoPlano = TipoPlano.PRATA,
    val mensalidade: BigDecimal = BigDecimal.ZERO,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: BigDecimal = BigDecimal.ZERO): PlanoEntity(id, tipoPlano)