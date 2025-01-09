package br.com.elias;

import java.util.Date;

public class NotaFiscal {

	int    talao;
	int    sequencia;
	String cnpj;
	String endereco;
	Date   data;

	public NotaFiscal(int talao, int sequencia, String cnpj, String endereco, Date data) {
		super();
		this.talao = talao;
		this.sequencia = sequencia;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.data = data;
	}

	public void   setTalao(int talao)          { this.talao = talao; }
	public void   setSequencia(int sequencia)  { this.sequencia = sequencia; }
	public void   setCnpj(String cnpj)         { this.cnpj = cnpj; }
	public void   setEndereco(String endereco) { this.endereco = endereco; }
	public void   setData(Date data)           { this.data = data; }
	public int    getTalao()                   { return talao; }
	public int    getSequencia()               { return sequencia; }
	public String getCnpj()                    { return cnpj; }
	public String getEndereco()                { return endereco; }
	public Date   getData()                    { return data; }

	@Override
	public String toString() {
		return "NotaFiscal [talao=" + talao + ", sequencia=" + sequencia + ", cnpj=" + cnpj + ", endereco=" + endereco
				+ ", data=" + data + "]";
	}
}
