package br.com.cbd.bancodigital.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Validation {
	
	public static boolean validaNome(String nome) {
		return nome.matches("[a-z, A-Z, ]{2,100}");
	}
	
	public static boolean qtdCPF(String cpf) {
		return cpf.matches("[0-9]{3}[.]{1}[0-9]{3}[.]{1}[0-9]{3}[-]{1}[0-9]{2}");
	}
	
	public static boolean validaCEP(String cep) {
		return cep.matches("[0-9]{5}[-]{1}[0-9]{3}");
	}
	
	public static boolean validaData(String dataNascimento) {
		if(dataNascimento.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
			try {
				LocalDate localDate = LocalDate.parse(dataNascimento, dateTimeFormatter);
				return true;
			} catch (DateTimeParseException e) {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public static boolean validaIdade(String data) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		LocalDate localDate = LocalDate.parse(data, dateTimeFormatter);
		if(Period.between(localDate, LocalDate.now()).getYears() < 18) {
			return false;
		}else {
			return true;
		}
	}
	
	
	//-------------------------- Valida o CPF recebido -----------------------
	public static boolean validaCPF(String cpf){
		if(qtdCPF(cpf)) {
			StringBuilder str = new StringBuilder(cpf.replace(".", "".replace("-", "")).substring(0, 9));
			if(str.toString().equals("111111111") || str.toString().equals("222222222") || str.toString().equals("333333333") || str.equals("444444444")
					|| str.toString().equals("555555555") || str.toString().equals("666666666") || str.toString().equals("777777777")||
					str.toString().equals("888888888") || str.toString().equals("999999999") || str.toString().equals("000000000")) {
				return false;
			}
			int digito1, digito2;
			int validador = 0;
			str = str.reverse();
			for(int i = 10; i > 1; i--) {
				validador = validador + (i) * (int)(str.charAt(i-2)-48);
			}
			if((validador * 10) % 11 == 10) {
				digito1 = 0;
			}else {
				digito1 = (validador * 10) % 11;
			}
			if(digito1 == (int)(cpf.charAt(cpf.length()-2)-48)) {
				str = str.reverse().append(digito1).reverse();
				validador = 0;
				for(int i = 11; i > 1; i--) {
					validador += (int)(str.charAt(i-2)-48) * i;
				}
				if((validador*10) % 11 == 10) {
					digito2 = 0;
				}else {
					digito2 = (validador*10) % 11;
				}
				if(digito2 == (int)(cpf.charAt(cpf.length()-1)-48)) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;			
			}
		}else {
			return false;
		}
	}
}
