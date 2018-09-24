package br.com.fiap.speventos.beans;

public class Pessoa extends Usuario {

	private int codUsuario;
	private long telefone;
	private String endereco;

	public Pessoa() {
	}

	public Pessoa(int codigoUsuario, String email, String senha, String nome, int codUsuario, long telefone,
			String endereco) {
		super(codigoUsuario, email, senha, nome);
		this.codUsuario = codUsuario;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
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
