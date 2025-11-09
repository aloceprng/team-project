package interface_adaptor.use_case;

import entity.Account;

import java.util.List;

public interface AccountDataAccessInterface {
    void saveAccount(Account account);
    Account getAccount(String accountNumber);
    List<Account> getAllAccounts();
}
