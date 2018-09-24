package antigo;

public class PessoaFisica extends Pessoa{

	private long cpf;
	private int cpfDigito;
	private int rg;
	private char rgDigito;
	private char genero;
	private String dataNascimento;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(int codigoUsuario, String email, String senha, String nome, long telefone, 
			String endereco, long cpf, int cpfDigito, int rg, char rgDigito, 
			char genero, String dataNascimento) {
		super(codigoUsuario, email, senha, nome, telefone, endereco);
		this.cpf = cpf;
		this.cpfDigito = cpfDigito;
		this.rg = rg;
		this.rgDigito = rgDigito;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
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
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
