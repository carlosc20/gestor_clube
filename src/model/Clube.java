package model;

import data.FacadeData;
import view.GUI;

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

    public Aluno getAluno(int num){
        // TODO: clone, exception?

        Aluno a = this.alunos.get(num);
        return a; //.clone();



    }


    /**
     * Adicionar um membro.
     * Se o membro já existe, não faz nada
     */
    /*
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
    */

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
