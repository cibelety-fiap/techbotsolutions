package br.com.fiap.speventos.beans;

public class Pessoa extends Usuario {

	private long telefone;
	private String endereco;

	public Pessoa() {
	}

	public Pessoa(int codigoUsuario, String email, String senha, String nome, long telefone, String endereco) {
		super(codigoUsuario, email, senha, nome);
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}