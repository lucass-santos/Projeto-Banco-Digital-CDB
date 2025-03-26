package br.com.cbd.bancodigital.dao;

import java.util.ArrayList;

import br.com.cbd.bancodigital.entity.Conta;

public class ContaDAO {
	private ArrayList<Conta> listaDeContas = new ArrayList<>();
	
	public boolean addConta(Conta conta) {
		return listaDeContas.add(conta);
	}
	
	public Conta getConta(int agencia, int numero) {
		for(Conta c: listaDeContas) {
			if(c.getAgencia() == agencia && c.getNumero() == numero) {
				return c;
			}
		}
		
		return null;
	}
	
	public ArrayList<Conta> getListaDeContas(){
		return listaDeContas;
	}
}
