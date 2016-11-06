package br.com.pogamando.validation.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.pogamando.validation.groups.PessoaFisica;
import br.com.pogamando.validation.groups.PessoaJuridica;
import br.com.pogamando.validation.groups.sequence.ClienteGroupSequenceProvider;

@GroupSequenceProvider(value = ClienteGroupSequenceProvider.class)
public class Cliente {

	@NotNull
	private String nome;
	
	@NotNull
	private String tipo;

	@CPF(groups = PessoaFisica.class)
	@CNPJ(groups = PessoaJuridica.class)
	private String cpfCnpj;

	public Cliente(String nome, String tipo, String cpfCnpj) {
		this.nome = nome;
		this.tipo = tipo;
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

}
