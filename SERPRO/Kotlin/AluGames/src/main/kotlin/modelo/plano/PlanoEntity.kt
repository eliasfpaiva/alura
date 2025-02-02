package modelo.plano

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Int = 0,
    @Enumerated(EnumType.STRING)
    open val tipo: TipoPlano = TipoPlano.BRONZE)

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