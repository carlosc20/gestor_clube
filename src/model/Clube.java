package model;

import java.util.Map;
import java.util.HashMap;
import java.util.Observable;

public class Clube extends Observable {

    private Map<Integer,Aluno> alunos;

    // Construtor

    public Clube() {
        this.alunos = new HashMap<>();
    }




    public Map<Integer, Aluno> getAlunos(){
        // TODO: clone
        return alunos;
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
     * Se o membro já existe, é substituido.
     */
    public void addAluno(Aluno a){

    /*
        if (!update) {
            this.setChanged();
            this.notifyObservers();
        }
    */
        System.out.println("ola");
    }

/*

    public void delAluno(String num) throws TurmaException {
        if (!this.turma.containsKey(num)) {
            StringBuffer sb = new StringBuffer("Aluno ");
            sb.append(num);
            sb.append(" inexistente!");
            throw new TurmaException(sb.toString());
        }
        this.turma.remove(num);
        this.setChanged();
        this.notifyObservers();
    }
*/

}
