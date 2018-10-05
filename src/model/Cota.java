package model;

import java.time.LocalDate;

public class Cota {
    private LocalDate data;
    private int valor;

    public Cota(){
        this.data = LocalDate.now();
        this.valor = 5;
    }
    public Cota(Cota c){
        this.data = c.getData();
        this.valor = c.getValor();
    }

    public LocalDate getData() {
        return data;
    }

    public int getValor() {
        return valor;
    }

    public Cota clone(){
        return new Cota(this);
    }
}
