package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;
import java.time.LocalDate;

public class FacadeModel extends Observable {
    private static FacadeModel INSTANCE = new FacadeModel();
    private Clube clube = new Clube ();

    public static FacadeModel getInstance() {
        return INSTANCE;
    }

    private FacadeModel() {}

    public void addAluno(String nome, int numero, String curso, LocalDate ano, String morada) throws AlunoJaExisteException, IOException {
        try {
            clube.addAluno(new Aluno(nome, numero, curso, ano, morada));
        } finally {
            setChanged();
            notifyObservers();
        }
    }

    public void editAluno(String nome, int numero, String curso, LocalDate ano, String morada) throws IOException {
        try{
            clube.editAluno(new Aluno(nome, numero, curso, ano, morada));
        }finally {
            setChanged();
            notifyObservers();
        }

    }

    public Set<Integer> getAlunosNumero() {
        return clube.getAlunos().keySet();
    }


    public String getAlunoNome(int numero) throws AlunoNaoExisteException {
        return clube.getAluno(numero).getNome();
    }

    public String getAlunoCurso(int numero) throws AlunoNaoExisteException {
        return clube.getAluno(numero).getCurso();
    }

    public LocalDate getAlunoAno(int numero) throws AlunoNaoExisteException {
        return clube.getAluno(numero).getAno();
    }

    public String getAlunoMorada(int numero) throws AlunoNaoExisteException {
        return clube.getAluno(numero).getMorada();
    }

    public void delAluno(int numero) throws AlunoNaoExisteException, IOException {
        try {
            clube.delAluno(numero);
        } finally {
            setChanged();
            notifyObservers();
        }
    }
}
