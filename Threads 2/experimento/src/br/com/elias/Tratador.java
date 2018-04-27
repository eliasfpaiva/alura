package br.com.elias;

import java.lang.Thread.UncaughtExceptionHandler;

public class Tratador implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(e.getMessage() + "\nConsegui /o/");
	}

}
