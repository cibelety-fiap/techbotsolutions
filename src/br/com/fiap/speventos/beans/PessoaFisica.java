package br.com.fiap.speventos.beans;

public class PessoaFisica extends Pessoa {

	private int codUsuario;
	private long cpf;
	private int cpfDigito;
	private char genero;
	private int rg;
	private char rgDigito;
	private String dataNascimento;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int codigoUsuario, String email, String senha, String nome, int codUsuario, long telefone,
			String endereco, int codUsuario2, long cpf, int cpfDigito, char genero, int rg, char rgDigito,
			String dataNascimento) {
		super(codigoUsuario, email, senha, nome, codUsuario, telefone, endereco);
		codUsuario = codUsuario2;
		this.cpf = cpf;
		this.cpfDigito = cpfDigito;
		this.genero = genero;
		this.rg = rg;
		this.rgDigito = rgDigito;
		this.dataNascimento = dataNascimento;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getCpfDigito() {
		return cpfDigito;
	}

	public void setCpfDigito(int cpfDigito) {
		this.cpfDigito = cpfDigito;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public char getRgDigito() {
		return rgDigito;
	}

	public void setRgDigito(char rgDigito) {
		this.rgDigito = rgDigito;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}