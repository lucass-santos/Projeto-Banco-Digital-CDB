package br.com.cbd.bancodigital.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Cliente {
	private UUID id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Endereco endereco;
	
	
	
	
	public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
