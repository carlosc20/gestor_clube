package model;

import data.FacadeData;
import exception.AlunoNaoExisteException;
import view.GUI;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Observable;

public class Clube extends Observable implements Serializable {

    private FacadeData data;
    private Map<Integer,Aluno> alunos;

    // Construtor

    public Clube() {

        Clube clube;
        data = FacadeData.getInstance();

        try {
            clube = (Clube) data.accessState();
            this.alunos = clube.getAlunos();
        } catch (Exception e) {
            this.alunos = new HashMap<>();
        }

        System.out.println(this.alunos);
    }


    public Map<Integer, Aluno> getAlunos(){
        HashMap<Integer,Aluno> res = new HashMap<>();
        for(Aluno a : this.alunos.values()) {
            res.put(a.getNumero(),a.clone());
        }
        return res;
    }

    public void pagarQuota(Integer numero, Double valor){
        // TODO: clone

    }

    public Aluno getAluno(int num) throws exception.AlunoNaoExisteException {
        // TODO: exception?

        Aluno a = this.alunos.get(num);
        if(a == null) {
            throw new exception.AlunoNaoExisteException(num);
        } else {
            return a.clone();
        }
    }


    /**
     * Adicionar um membro.
     * Se o membro já existe, não faz nada
     */
    public void addAluno(Aluno a) throws exception.AlunoJaExisteException, IOException {

        Aluno copia = a.clone();
        int num = a.getNumero();

        Aluno aluno = alunos.putIfAbsent(num, copia);
        if(aluno != null) {
            throw new exception.AlunoJaExisteException(num);
        }

        data.saveState(this);
        this.setChanged();
        this.notifyObservers();

        System.out.println("Aluno adicionado" + a.getNome());
    }


    public void delAluno(int num) throws exception.AlunoNaoExisteException, IOException {

        Aluno aluno = alunos.remove(num);
        data.saveState(this);

        if (aluno == null) {
            throw new exception.AlunoNaoExisteException(num);
        }

        setChanged();
        notifyObservers();

        System.out.println("Aluno removido" + aluno.getNome());
    }


}
