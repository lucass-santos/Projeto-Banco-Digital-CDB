package br.com.cbd.bancodigital.entity;

public class ContaCorrente extends Conta{

	private double taxaManutencao;
	
	public ContaCorrente(int agencia, int numero, long saldo, Cliente cliente, Categoria categoria, double taxaManutencao) {
		super(agencia, numero, saldo, cliente, categoria);
		this.taxaManutencao= taxaManutencao;
				}

	public double getTaxaManutencao() {
		return taxaManutencao;
	}

	public void setTaxaManutencao(double taxaManutencao) {
		this.taxaManutencao = taxaManutencao;
	}
	
	
}
