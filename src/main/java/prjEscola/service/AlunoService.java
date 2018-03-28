package prjEscola.service;

import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import prjEscola.dao.AlunoDao;
import prjEscola.dto.AlunoDto;
import prjEscola.model.Aluno;
import prjEscola.model.Curso;

@RestController
@RequestMapping(value="/aluno")
@CrossOrigin(allowCredentials="true")
public class AlunoService {

	@RequestMapping(value="/cadastro", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
		AlunoDao alunoDao = new AlunoDao();
		
		try{
			if(Integer.parseInt(aluno.getMatricula()) < 1 || Integer.parseInt(aluno.getMatricula()) > 9999)
				return new ResponseEntity<Aluno>(HttpStatus.BAD_REQUEST);
			else if(aluno.getNome() == null)
				return new ResponseEntity<Aluno>(HttpStatus.BAD_REQUEST);
			else if(aluno.getNome().length() < 51)
				return new ResponseEntity<Aluno>(HttpStatus.BAD_REQUEST);
			else {
				alunoDao.salvarAluno(aluno);
			}
			return new ResponseEntity<Aluno>(HttpStatus.CREATED);
				
				
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Aluno>(HttpStatus.BAD_REQUEST);	
		}
		
	}
	@RequestMapping(value="/cursos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> consultarCurso(){
		AlunoDao alunodao = new AlunoDao();
		List<Curso> cursos =  alunodao.consultarCursos();
		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/alunos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Aluno>> consultarAlunos(){
		AlunoDao alunoDao = new AlunoDao();
		List<Aluno> alunos = alunoDao.consultarAlunos();
		return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
	}
}
