package modelo.plano

fun PlanoEntity.paraPlano() : Plano {
    return if (this is PlanoAssinaturaEntity)
        PlanoAssinatura(this.id, this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao)
    else
        PlanoPadrao(this.id)
}

fun Plano.paraEntidade() : PlanoEntity {
    return if (this is PlanoAssinatura)
        PlanoAssinaturaEntity(this.id, this.tipoPlano, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao)
    else
        PlanoPadraoEntity(this.id)
}