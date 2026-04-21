import com.masu.models.Transaction;
import com.masu.services.TransactionService;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionServiceTest {

    private final TransactionService transactionService = new TransactionService();

    @Test
    public void testAddTransaction() {
        Transaction t = prepareTransaction();
        transactionService.addTransaction(t);

        assertEquals(1, transactionService.getTransactions().size());
    }

    @Test
    public void testUpdateTransaction() {
        assertEquals(0, transactionService.getTransactions().size());
        Transaction t = prepareTransaction();
        transactionService.addTransaction(t);
        assertEquals(10.0f, transactionService.getTransaction(t.getId()).getAmount());
        t.setAmount(20.0f);
        transactionService.updateTransaction(t);
        assertEquals(1, transactionService.getTransactions().size());
        assertEquals(20.0f, transactionService.getTransaction(t.getId()).getAmount());
    }

    @Test
    public void testDeleteTransaction() {
        Transaction t = prepareTransaction();
        transactionService.addTransaction(t);
        assertEquals(1, transactionService.getTransactions().size());
        transactionService.deleteTransaction(t.getId());
        assertEquals(0, transactionService.getTransactions().size());
    }

    private static @NonNull Transaction prepareTransaction() {
        Transaction t = new Transaction();
        t.setId("1");
        t.setDate(new Date());
        t.setNameOfReceiverOrSender("Susum");
        t.setAmount(10.0f);
        return t;
    }


}
