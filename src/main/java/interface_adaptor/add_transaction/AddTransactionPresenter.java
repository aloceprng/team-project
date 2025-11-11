package interface_adaptor.add_transaction;

import use_case.add_transaction.AddTransactionOutputBoundary;
import use_case.add_transaction.AddTransactionOutputData;

public class AddTransactionPresenter implements AddTransactionOutputBoundary {

    @Override
    public void prepareTransactionSuccessView(AddTransactionOutputData addTransactionOutputData) {
        // with a popup, display the success message with info of the transaction
    }

    @Override
    public void prepareTransactionFailView(String errorMessage) {
        // with a popup, display the errorMessage as to why the transaction failed.
    }
}
