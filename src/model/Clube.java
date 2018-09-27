package model;

import java.util.Map;
import java.util.HashMap;
import java.util.Observable;

public class Clube extends Observable implements ModelFacade {

    private Map<String,Membro> membrosPorNome;
    private Map<Integer,Membro> membrosPorNum;

    // Construtor

    public Clube() {
        this.membrosPorNome = new HashMap<>();
        this.membrosPorNum = new HashMap<>();
    }

    /**
     * Adicionar um membro.
     * Se o membro já existe, é substituido.
     */
    @Override
    public void addMembro(String nome, int numero) {
        //Membro m = new Membro(nome, numero);
        Membro m = new Membro();
        boolean update = this.membrosPorNum.containsKey(numero);
        this.membrosPorNum.put(numero,m);
        this.membrosPorNome.put(nome,m);
    /*
        if (!update) {
            this.setChanged();
            this.notifyObservers();
        }
    */
        System.out.println("ola");
    }


/*
    public Membro getMembroPorNr(String num) throws ClubeException {

        try {
            Membro a = this.membrosPorNum.get(num);
            return (Aluno)a.clone();
        }
        catch (NullPointerException e) {
            StringBuffer sb = new StringBuffer("Aluno ");
            sb.append(num);
            sb.append(" inexistente!");
            throw new TurmaException(sb.toString());
        }
    }


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
