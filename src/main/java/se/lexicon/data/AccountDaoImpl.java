package se.lexicon.data;

import se.lexicon.model.Account;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {

    Collection<Account> accountStorage = null;

    public AccountDaoImpl() {
        this.accountStorage = new HashSet<>();
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return accountStorage.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst();
    }

    @Override
    public Optional<Account> create(Account account) {
        accountStorage.add(account);
        return findById(account.getAccountId());
    }

    @Override
    public boolean delete(Integer id) {
        return accountStorage.removeIf(account -> account.getAccountId() == id);
    }

    @Override
    public Collection<Account> findAll() {
        return accountStorage;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountStorage.stream()
                .filter(account -> account.getAccountId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Account account) {
        accountStorage.removeIf(a -> a.getAccountId() == account.getAccountId());
        return accountStorage.add(account);
    }
}
