package prjEscola.dao;


import java.util.ArrayList;
import java.util.List;

import prjEscola.model.Aluno;
import prjEscola.model.Curso;

public class AlunoDao {

	private static ArrayList<Aluno> alunos ;
	private  Aluno aluno;
	private static ArrayList<Curso> cursoList;
	private  Curso curso;
	public AlunoDao() {
		if(alunos == null) {
			alunos = new ArrayList();
			aluno = new Aluno("Solteiro", "22", "Fred", "1");
			this.alunos.add(aluno);
			aluno = new Aluno("Casado", "22", "Tacio", "2");
			this.alunos.add(aluno);
			aluno = new Aluno();
		}
		if(cursoList == null ) {
			cursoList = new ArrayList<Curso>();
			curso = new Curso("1", "Historia" );
			cursoList.add(curso);
			curso = new Curso("2", "Informatica" );
			cursoList.add(curso);
			curso = new Curso("3", "Quimica" );
			cursoList.add(curso);
			curso = new Curso("4", "Engenharia Robotica" );
			cursoList.add(curso);
		}
		
		
	}
	public void salvarAluno(Aluno aluno2) {
		if(!this.alunos.contains(aluno2))
			if(verificarCurso(aluno2))
				this.alunos.add(aluno2);
	}
	private boolean verificarCurso(Aluno aluno) {
		for(Curso curso : this.cursoList) {
			if(aluno.getCurso().getCodigo().equals(curso.getCodigo()))
				return true;
		}
		return false;
	}
	public List<Curso> consultarCursos(){
		return this.cursoList;
	}
	public List<Aluno> consultarAlunos() {
		Curso curso = null;
		for (Aluno aluno : alunos) {
			for (Curso cursoBusca : cursoList) {
				curso = new Curso();
				if(cursoBusca.getCodigo().equals(aluno.getCurso().getCodigo())) {
					curso = cursoBusca;
					aluno.setCurso(curso);
				}
			}
			
		}
		return alunos;
	}
}
