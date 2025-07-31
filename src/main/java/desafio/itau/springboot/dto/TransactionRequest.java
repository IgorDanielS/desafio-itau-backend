package desafio.itau.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class TransactionRequest {

    @NotEmpty
    private Double valor;

    @NotEmpty
    private OffsetDateTime  dataHora;

}
