package model;

import java.io.IOException;
import java.util.Set;
import java.time.LocalDate;

public class FacadeModel {
    private static FacadeModel INSTANCE = new FacadeModel();
    private Clube clube = new Clube ();

    public static FacadeModel getInstance() {
        return INSTANCE;
    }

    private FacadeModel() {}

    public void addAluno(String nome, int numero, String curso, LocalDate ano, String morada) throws AlunoJaExisteException, IOException {
        clube.addAluno(new Aluno(nome, numero, curso, ano, morada));
    }

    public Set<Integer> getAlunosNumero() {
        return clube.getAlunos().keySet();
    }

    public String getAlunoNome(int numero) throws AlunoNaoExisteException {
        Aluno aluno = clube.getAlunos().get(numero);
        return aluno.getNome();
    }

    public String getAlunoCurso(int numero) throws AlunoNaoExisteException {
        Aluno aluno = clube.getAlunos().get(numero);
        return aluno.getCurso();
    }

    public LocalDate getAlunoAno(int numero) throws AlunoNaoExisteException {
        Aluno aluno = clube.getAlunos().get(numero);
        return aluno.getAno();
    }

    public String getAlunoMorada(int numero) throws AlunoNaoExisteException {
        Aluno aluno = clube.getAlunos().get(numero);
        return aluno.getMorada();
    }

    public void delAluno(int numero) throws AlunoNaoExisteException, IOException {
        clube.delAluno(numero);
    }
}
