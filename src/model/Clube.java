package model;

import view.GUI;

import java.util.Map;
import java.util.HashMap;
import java.util.Observable;

public class Clube extends Observable {

    private Map<Integer,Aluno> alunos;

    // Construtor

    public Clube() {

        this.alunos = new HashMap<>();

    }

    /**
     * Adicionar um membro.
     * Se o membro já existe, não faz nada
     */
    public Map<Integer, Aluno> getAlunos(){
        HashMap<Integer,Aluno> res = new HashMap<>();
        for(Aluno a : this.alunos.values()) {
            res.put(a.getNumero(),a.clone());
        }
        return res;
    }

    /**
     * Adicionar um membro.
     * Se o membro já existe, não faz nada
     */
    public void pagarQuota(Integer numero, Double valor){
        // TODO: clone

    }

    /**
     * Adicionar um membro.
     * Se o membro já existe, não faz nada
     */
    public Aluno getAluno(int num){
        // TODO: exception?

        return alunos.get(num).clone();
    }


    /**
     * Adicionar um membro.
     * Se o membro já existe, não faz nada
     */
    public void addAluno(Aluno a){

        Aluno copia = a.clone();
        int num = a.getNumero();
        boolean existe = alunos.containsKey(num);
        if(!existe) {
            alunos.put(num, copia);
            this.setChanged();
            this.notifyObservers();
        }

        System.out.println("Aluno adicionado" + a.getNome());
    }


    /*
    public void delAluno(int num) throws ClubeException {

        if (!alunos.containsKey(num)) {

            throw new ClubeException("Aluno" + num + " inexistente");
        }

        alunos.remove(num);
        setChanged();
        notifyObservers();
    }
    */

}
