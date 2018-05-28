<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="venda">
		<h1>Venda</h1>
		<p>Forma de Pagamento: <xsl:value-of select="formaDePagamento"></xsl:value-of></p>
		<xsl:apply-templates select="produtos"/>
	</xsl:template>
	<xsl:template match="produtos">
		<h2>Produtos</h2>
		<xsl:apply-templates select="produto"/>
	</xsl:template>
	<xsl:template match="produto">
		<h3><xsl:value-of select="nome"></xsl:value-of></h3>
		<p>R$ <xsl:value-of select="preco"></xsl:value-of></p>
	</xsl:template>
</xsl:stylesheet>