package desafio.itau.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

    public Transaction(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor(){
        return this.valor;
    }

    public OffsetDateTime getDataHora() {
        return this.dataHora;
    }
}
