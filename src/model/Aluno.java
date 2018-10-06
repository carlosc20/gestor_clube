package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno implements Serializable {

    private String nome;
    private int numero;
    private String curso;
    private LocalDate ano;
    private String morada;
    private ArrayList<Cota> cotas;


    public Aluno() {}

    public Aluno(String nome, int numero, String curso, LocalDate ano, String morada){
        this.nome = nome;
        this.numero = numero;
        this.curso = curso;
        this.ano = ano;
        this.morada = morada;
        this.cotas = new ArrayList<Cota>();
    }
    public Aluno(Aluno a){
        this.nome = a.getNome();
        this.numero = a.getNumero();
        this.curso = a.getCurso();
        this.ano = a.getAno();
        this.morada = a.getMorada();
        this.cotas = a.getCotas();
    }

    public ArrayList<Cota> getCotas() {
        ArrayList<Cota> res = new ArrayList<Cota>();
            for(Cota c : res){
                res.add(c.clone());
            }
        return res;
    }

    public String getCurso() {
        return curso;
    }

    public LocalDate getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public int getNumero(){
        return numero;
    }
    public Aluno clone(){
        return new Aluno(this);
    }
}
