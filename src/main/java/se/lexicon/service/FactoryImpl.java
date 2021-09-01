package se.lexicon.service;

import se.lexicon.data.AccountDao;
import se.lexicon.data.ClientDao;
import se.lexicon.model.Account;
import se.lexicon.model.Client;

import java.util.Optional;
import java.util.UUID;

public class FactoryImpl implements Factory {

    private AccountDao accountDao;
    private ClientDao clientDao;

    public FactoryImpl(AccountDao accountDao, ClientDao clientDao) {
        this.accountDao = accountDao;
        this.clientDao = clientDao;
    }

    @Override
    public Optional<Account> createAccount() {
        return accountDao.create(new Account(0, UUID.randomUUID().toString(), 0));
    }

    @Override
    public Optional<Account> createAccount(int id) {
        return accountDao.create(new Account(id, UUID.randomUUID().toString(), 0));
    }

    @Override
    public Optional<Client> createClient(String firstName, String lastName) {
        return clientDao.create(new Client(firstName, lastName));
    }

    @Override
    public Optional<Client> createClient(int id, String firstName, String lastName) {
        return clientDao.create(new Client(id, firstName, lastName));
    }
}
