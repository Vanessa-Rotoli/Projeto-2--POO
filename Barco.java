package edu.fatecmm.model;

public class Barco {

    public boolean isStatus;
    int tamanho;
    int contador;
    String nome;
    boolean status;

    void alterarStatus() {
        if (tamanho == contador) {
            status = false;
        }

    }
}