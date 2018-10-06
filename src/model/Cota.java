package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Cota implements Serializable {
    private LocalDate data;
    private double valor;

    public Cota(double valor){
        this.data = LocalDate.now();
        this.valor = valor;
    }
    public Cota(Cota c){
        this.data = c.getData();
        this.valor = c.getValor();
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public Cota clone(){
        return new Cota(this);
    }
}
