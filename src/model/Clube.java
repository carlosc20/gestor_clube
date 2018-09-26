package model;

import java.util.Map;
import java.util.HashMap;

public class Clube {

    private Map<String,Membro> membrosPorNome;
    private Map<Integer,Membro> membrosPorNr;

    // Construtor

    public Clube() {
        this.membrosPorNome = new HashMap<>();
        this.membrosPorNr = new HashMap<>();
    }

    // Métodos de instância

    /**
     * Adicionar um membro.
     * Se o membro já existe, é substituido.
     */
    public void addAluno(Aluno a) {
        Aluno copia = (Aluno)a.clone();
        String num= a.getNumero();
        boolean update = this.turma.containsKey(num);
        this.turma.put(num,copia);
        if (!update) {
            this.setChanged();
            this.notifyObservers();
        }
    }

    /**
     * Consultar um aluno
     */
    public Aluno getAluno(String num) throws TurmaException {

        try {
            Aluno a = this.turma.get(num);
            return (Aluno)a.clone();
        }
        catch (NullPointerException e) {
            StringBuffer sb = new StringBuffer("Aluno ");
            sb.append(num);
            sb.append(" inexistente!");
            throw new TurmaException(sb.toString());
        }
    }

    /**
     * Remover um aluno
     */
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
}
