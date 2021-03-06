package prjEscola.model;

public class Aluno {
	
	
	private String matricula;
	private String nome;
	private String estadoCivil;
	private Curso curso;
	
	
	public Aluno(String matricula, String nome, String estadoCivil, String curso) {
		this.curso = new Curso();
		this.matricula = matricula;
		this.estadoCivil = estadoCivil;
		this.nome = nome;
		this.curso.setCodigo(curso);
		
	}
	public Aluno(String matricula, String nome, String estadoCivil, Curso curso) {
	
		this.matricula = matricula;
		this.estadoCivil = estadoCivil;
		this.nome = nome;
		this.curso = curso;
		
	}
	public Aluno() {
		
	}
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
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	


}
