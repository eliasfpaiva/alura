package br.com.alura.bytebank;

import br.com.alura.bytebank.io.LeitorCSV;
import br.com.alura.bytebank.model.Pagamento;

import java.io.IOException;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws IOException {
//        new OpcoesPagamento().mensagemDeBoasVindas();
        LeitorCSV leitorCSV =new LeitorCSV();
        List<Pagamento> lista = leitorCSV.ler(1);

        for (Pagamento p: lista) {
                double valorBruto = p.getValor();
            if (valorBruto>100) {
                double valorComAcrescimo = valorBruto *1.1;
                p.setValor(valorComAcrescimo);
            }
            System.out.println(p);
        }
    }
}