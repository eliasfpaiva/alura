package br.com.alura.java8;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestaDatas {

	public static void main(String[] args) {
		
		LocalDate dataTeste = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(dataTeste.format(formatador));
		
//		LocalDate dataTeste = LocalDate.now();
//		System.out.println(dataTeste);
//		
//		LocalDate dataTeste2 = LocalDate.of(2099, 01, 25);
//		System.out.println(dataTeste);
//				
//		Period periodo = Period.between(dataTeste, dataTeste2);
//		System.out.println(periodo);
		
//		LocalDate dataTeste = LocalDate.of(2099, Month.JANUARY, 25);
//		System.out.println(dataTeste);
//		
//		LocalDate dataTeste2 = LocalDate.of(2099, 01, 25);
//		System.out.println(dataTeste);
						
//		LocalDate dataAqui = LocalDate.now();
//		
//		System.out.println(dataAqui);
	}
}
