package br.com.alura.bytebank;

import br.com.bytebankconta.banco.modelo.Conta;
import br.com.bytebankconta.banco.modelo.ContaCorrente;

public class TesteBiblioteca {

    public static void main(String[] args) {
        Conta c = new ContaCorrente(123, 321);
        System.out.println(c.getNumero());
    }
}