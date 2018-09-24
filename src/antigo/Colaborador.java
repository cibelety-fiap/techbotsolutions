package antigo;

public class Colaborador extends Usuario {

	private String departamento;
	private String nivelAcesso;
	
	public Colaborador() {
		super();
	}
		
	public Colaborador(int codigoUsuario, String email, String senha, String nome, String departamento,
			String nivelAcesso) {
		super(codigoUsuario, email, senha, nome);
		this.departamento = departamento;
		this.nivelAcesso = nivelAcesso;
	}

	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
}
