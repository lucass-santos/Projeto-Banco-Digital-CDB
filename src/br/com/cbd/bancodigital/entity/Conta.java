package br.com.cbd.bancodigital.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class  Conta {
	private int agencia;
	private int numero;
	private LocalDateTime dataAbertura;
	private long saldo;
	private Cliente cliente;
	private Categoria categoria;
	private boolean contaAtiva;
	private LocalDateTime dataInatividade;
	private boolean contaEncerrada;
	private LocalDateTime dataEncerramento;
	private ArrayList<Cartao> cartoes = new ArrayList<>();
	
	
	public Conta(int agencia, int numero, long saldo, Cliente cliente, Categoria categoria) {
		this.agencia = agencia;
		this.numero = numero;
		this.dataAbertura = LocalDateTime.now();
		this.saldo = saldo;
		this.cliente = cliente;
		this.categoria = categoria;
		this.contaAtiva = true;
		this.contaEncerrada = false;
	}


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public long getSaldo() {
		return saldo;
	}


	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public boolean isContaAtiva() {
		return contaAtiva;
	}


	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}


	public LocalDateTime getDataInatividade() {
		return dataInatividade;
	}


	public void setDataInatividade(LocalDateTime dataInatividade) {
		this.dataInatividade = dataInatividade;
	}


	public boolean isContaEncerrada() {
		return contaEncerrada;
	}


	public void setContaEncerrada(boolean contaEncerrada) {
		this.contaEncerrada = contaEncerrada;
	}


	public LocalDateTime getDataEncerramento() {
		return dataEncerramento;
	}


	public void setDataEncerramento(LocalDateTime dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}


	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}


	public void setCartoes(ArrayList<Cartao> cartoes) {
		this.cartoes = cartoes;
	}


	
	
	
	
}
