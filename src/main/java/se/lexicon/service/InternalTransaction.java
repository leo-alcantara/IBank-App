package se.lexicon.service;

import se.lexicon.data.AccountDao;
import se.lexicon.data.ClientDao;
import se.lexicon.model.Account;

import java.util.NoSuchElementException;

public class InternalTransaction implements Transaction {

    private AccountDao accountDao;
    private ClientDao clientDao;

    public InternalTransaction(AccountDao accountDao, ClientDao clientDao) {
        this.accountDao = accountDao;
        this.clientDao = clientDao;
    }
    @Override
    public boolean transfer(Integer authorizedClientId, double amount, String fromAccountNumber, String toAccountNumber) {
        boolean verifiedAccount = verifyClient(authorizedClientId);

        Account from = accountDao.findByAccountNumber(fromAccountNumber).orElseThrow(NoSuchElementException::new);
        Account to = accountDao.findByAccountNumber(toAccountNumber).orElseThrow(NoSuchElementException::new);

        if(verifiedAccount){
            if (from.getAccountBalance() >= amount){
                from.setAccountBalance(from.getAccountBalance() - amount);
                to.setAccountBalance(to.getAccountBalance() + amount);

                boolean fromUpdated = accountDao.update(from);
                boolean toUpdated = accountDao.update(to);

                return fromUpdated & toUpdated;
            }
        }
        return false;
    }

    @Override
    public boolean verifyClient(Integer authorizedClientId) {
        return clientDao.findById(authorizedClientId).isPresent();
    }
}
