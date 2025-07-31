package desafio.itau.springboot.services;

import desafio.itau.springboot.exceptions.UnprocessableEntityException;
import desafio.itau.springboot.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction) throws UnprocessableEntityException {
        if(transaction.getDataHora().isAfter(OffsetDateTime.now()) || transaction.getValor() < 0) {
            throw new UnprocessableEntityException();
        }
        transactions.add(transaction);
    }
    public void clearTransactions() {
        transactions.clear();
    }

    public DoubleSummaryStatistics getLastMinuteStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}
