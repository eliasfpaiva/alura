package br.com.elias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestaExpressoes {

	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
		Matcher matcher = pattern.matcher("2007-12-31");
		
		if(matcher.find())
		{
			String novaString = matcher.group(3) + "-" + matcher.group(2) + "-" + matcher.group(1);
			System.out.println(novaString.replaceAll("-", "/"));
		}
	}
}
