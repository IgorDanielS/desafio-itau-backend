package desafio.itau.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class Transaction {

    private double valor;
    private OffsetDateTime dataHora;

}
