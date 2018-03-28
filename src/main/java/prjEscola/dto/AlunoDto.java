package prjEscola.dto;

import prjEscola.model.Curso;

public class AlunoDto {
	
	private String matricula;
	private String nome;
	private String estadoCivil;
	private String cursoCodigo;
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCursoCodigo() {
		return cursoCodigo;
	}
	public void setCursoCodigo(String cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}
	
	

}
