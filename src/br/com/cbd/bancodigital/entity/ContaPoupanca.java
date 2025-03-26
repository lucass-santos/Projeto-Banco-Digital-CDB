package br.com.cbd.bancodigital.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class ContaPoupanca extends Conta{
	private double taxaRendimento;
	private HashMap<String, Integer> redimentoDeposito = new HashMap<String, Integer>();

	public ContaPoupanca(int agencia, int numero, long saldo, Cliente cliente, Categoria categoria,
			double taxaRendimento) {
		super(agencia, numero, saldo, cliente, categoria);
		this.taxaRendimento = taxaRendimento;
	}

	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
	
	
}
