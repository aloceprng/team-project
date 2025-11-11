package use_case.add_transaction;

import data_access.AccountDataAccessObject;
import entity.Account;
import entity.Transaction;

import java.time.LocalDate;

public class AddTransactionInteractor implements AddTransactionInputBoundary {

    private final AccountDataAccessObject accountDataAccessObject;
    // presenter

    public AddTransactionInteractor (AccountDataAccessObject accountDataAccessObject) {
        this.accountDataAccessObject = accountDataAccessObject;
    }

    @Override
    public void execute(AddTransactionInputData addTransactionInputData) {
        final double transactionAmount = addTransactionInputData.getAmount();
        final String accountNumber = addTransactionInputData.getAccountNumber();
        final LocalDate transactionDate = addTransactionInputData.getDate();
        final Transaction.TransactionType transactionType = addTransactionInputData.getType();
        final Transaction.TransactionCategory transactionCategory = addTransactionInputData.getCategory();

        Account account = accountDataAccessObject.getAccount(accountNumber);
        if (account == null) {
            // account does not exist
        } else {
            if (account.getAccountBalance() - transactionAmount < 0) {
                // account balance cannot go below. Give red error on screen
            }
            Transaction transaction = new Transaction(
                    transactionAmount,
                    transactionType,
                    transactionCategory,
                    transactionDate,
                    accountNumber
            );
            account.applyTransaction(transaction);

            final AddTransactionOutputData addTransactionOutputData = new AddTransactionOutputData(
                    "successful",
                    accountNumber,
                    transactionAmount,
                    account.getAccountBalance()
            );
            // presenter call
        }

    }
}
