package model;

import java.time.LocalDate;

public class Aluno {

    private String nome;
    private int numero;
    private String curso;
    private LocalDate ano;
    private String morada;


    public Aluno() {
    }

    public Aluno(String nome, int numero, String curso, LocalDate ano, String morada){
        this.nome = nome;
        this.numero = numero;
        this.curso = curso;
        this.ano = ano;
        this.morada = morada;
    }
    public Aluno(Aluno a){
        this.nome = a.getNome();
        this.numero = a.getNumero();
        this.curso = a.getCurso();
        this.ano = a.getAno();
        this.morada = a.getMorada();
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
