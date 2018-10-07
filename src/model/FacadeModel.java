package model;

import java.io.IOException;
import java.util.ArrayList;
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
            notifyObservers(0);
        }
    }

    public void editAluno(String nome, int numero, String curso, LocalDate ano, String morada) throws IOException {
        try{
            clube.editAluno(new Aluno(nome, numero, curso, ano, morada));
        } finally {
            setChanged();
            notifyObservers(0);
        }

    }

    public void pagarCota(int numero, double valor) throws IOException{
        try{
            clube.pagarQuota(numero, valor);
        } finally {
            setChanged();
            notifyObservers(1);
        }

    }
    // não há emcapsulamento ou lá o que é
    public ArrayList<Double> getCotasValor(int numero)throws AlunoNaoExisteException{
           Aluno a = clube.getAluno(numero);
           ArrayList<Cota> c = a.getCotas();

           ArrayList<Double> d = new ArrayList<Double>();
           for(Cota cota : c){
               d.add(cota.getValor());
           }
           return d;
    }
    public ArrayList<LocalDate> getCotasData(int numero)throws AlunoNaoExisteException{
        Aluno a = clube.getAluno(numero);
        ArrayList<Cota> c = a.getCotas();

        ArrayList<LocalDate> l = new ArrayList<LocalDate>();
        for(Cota cota : c){
            l.add(cota.getData());
        }
        return l;
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
            notifyObservers(0);
        }
    }
}
