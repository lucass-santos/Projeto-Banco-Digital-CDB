package br.com.cbd.bancodigital.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

import br.com.cbd.bancodigital.entity.Cliente;
import br.com.cbd.bancodigital.entity.Endereco;
import br.com.cbd.bancodigital.service.Validation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		if(cadastraCliente() == null) {
			System.out.println("Cliente menor de idade. Não é possível a abertura de conta.");
		}else {
			System.out.println("Cliente cadastrado com sucesso!");
		}
		
		
		
		sc.close();
	}
	
	
	//------------------ Cadastro do cliente ------------------
	public static Cliente cadastraCliente() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vamos cadastrar seus dados pessoais.\n");
		System.out.print("Digite o seu nome: ");
		String nome = sc.nextLine();
		while(!Validation.validaNome(nome)) {
			System.out.println("Nome inválido. Seu nome deve conter, no mínimo duas letras.");
			System.out.print("Digite o seu nome: ");
			nome = sc.nextLine();
		}
		System.out.print("Digite o seu CPF, exemplo xxx.xxx.xxx-xx: ");
		String cpf = sc.next();
		while(!Validation.validaCPF(cpf)) {
			System.out.println("CPF inválido ou digitado incorretamente. Digite um CPF válido, com 11 digitos, pontos e virgulas.");
			System.out.print("Digite o seu CPF, exemplo xxx.xxx.xxx-xx: ");
			cpf = sc.next();
		}
		System.out.print("Digite a sua data de nascimento: ");
		String dataNascimento = sc.next();
		while(!Validation.validaData(dataNascimento)) {
			System.out.println("Data de nascimento incorreta. Digite uma data de nascimento válida no formato dd/mm/aaaa.");
			System.out.print("Digite a sua data de nascimento: ");
			dataNascimento = sc.next();
		}
		if(Validation.validaIdade(dataNascimento) == false) {
			sc.close();
			return null;
		}
		LocalDate localDate = LocalDate.parse(dataNascimento, dateTimeFormatter);
		Cliente cliente = new Cliente(nome, cpf, localDate, cadastraEndereco());
		sc.close();
		return cliente;
	}
	
	
	
	//------------------ Cadastro do endereço do cliente ------------------
	public static Endereco cadastraEndereco() {
		Scanner sc = new Scanner(System.in);
		int escolha;
		String complemento = "";
		System.out.println("Agora vamos cadastrar o seu endereco.\n");
		System.out.print("Digite o tipo de logradouro: ");
		String tipoLogradouro = sc.next();
		System.out.print("Digite o logradouro: ");
		String logradouro = sc.next();
		System.out.print("Digite o numero do endereco: ");
		String numero = sc.next();
		sc.nextLine();
		System.out.print("Digite o bairo: ");
		String bairro = sc.nextLine();
		System.out.print("Possui complemento?\n"
						+  "1 - sim\n"
						+  "2 - nao\n"
						+  "Escolha: ");
		escolha = sc.nextInt();
		while(escolha != 1 && escolha != 2) {
			System.out.println("Opcao invalida. Digite apenas uma das opcoes.");
			System.out.print("Possui complemento?\n"
					+  "1 - sim\n"
					+  "2 - nao\n"
					+  "Escolha: ");
			escolha = sc.nextInt();
		}
		sc.nextLine();
		if(escolha == 1) {
			System.out.print("Digite o complemente: ");
			complemento = sc.nextLine();
		}
		System.out.print("Digite a sua cidade: ");
		String cidade = sc.nextLine();
		System.out.print("Digite o estado, com duas letras. Exemplo SP: ");
		String estado = sc.next().toUpperCase();
		while(estado.length() != 2) {
			System.out.println("Estado informado de forma errada. Digite  estado com duas letras.");
			System.out.print("Digite o estado, com duas letras. Exemplo SP: ");
			estado = sc.next().toUpperCase();
		}
		System.out.print("Digite o cep da residência. Exemplo xxxxx-xxx: ");
		String cep = sc.next();
		while(!Validation.validaCEP(cep)) {
			System.out.println("CEP inválido. Digite o cep no formato indicado.");
			System.out.print("Digite o cep da residência. Exemplo xxxxx-xxx: ");
			cep = sc.next();
		}
		sc.close();
		if(complemento.equals("")) {
			return new Endereco(tipoLogradouro, logradouro, numero, bairro, cidade, estado, cep);
		}else {
			return new Endereco(tipoLogradouro, logradouro, numero, bairro, complemento, cidade, estado, cep);
		}
	}
}
