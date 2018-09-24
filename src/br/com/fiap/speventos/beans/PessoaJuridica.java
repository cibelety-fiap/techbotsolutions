package br.com.fiap.speventos.beans;

public class PessoaJuridica extends Pessoa {

	private int codUsuario;
	private String razaoSocial;
	private long cnpj;
	private int cnpjDigito;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(int codigoUsuario, String email, String senha, String nome, int codUsuario, long telefone,
			String endereco, int codUsuario2, String razaoSocial, long cnpj, int cnpjDigito) {
		super(codigoUsuario, email, senha, nome, codUsuario, telefone, endereco);
		codUsuario = codUsuario2;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cnpjDigito = cnpjDigito;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public int getCnpjDigito() {
		return cnpjDigito;
	}

	public void setCnpjDigito(int cnpjDigito) {
		this.cnpjDigito = cnpjDigito;
	}

}