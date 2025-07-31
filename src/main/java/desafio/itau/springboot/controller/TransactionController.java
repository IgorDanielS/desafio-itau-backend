package desafio.itau.springboot.controller;

import desafio.itau.springboot.dto.TransactionRequest;
import desafio.itau.springboot.exceptions.UnprocessableEntityException;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public  TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
       try {
           transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }catch (UnprocessableEntityException __){
           return  ResponseEntity.unprocessableEntity().build();
       }
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransaction(){
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
