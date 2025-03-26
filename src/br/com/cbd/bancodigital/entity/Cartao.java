package br.com.cbd.bancodigital.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Cartao {

	private String numero;
	private String nome;
	private final long cvv;
	private double taxaUso;
	private String senha;
	private boolean status;
	private LocalDate dataVencimento;
	
	public Cartao(String nome, double taxaUso, String senha) {
		this.numero = "7744"+ Math.round(Math.random()*100000000);
		this.nome = nome;
		this.cvv = Math.round(Math.random()*1000);
		this.taxaUso = taxaUso;
		this.dataVencimento = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ofPattern("dd/MM/uuuu"));
		this.status = true;
		this.senha = senha;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCvv() {
		return cvv;
	}
	
	public double getTaxaUso() {
		return taxaUso;
	}
	public void setTaxaUso(double taxaUso) {
		this.taxaUso = taxaUso;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	
	
	
}
