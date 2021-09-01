package se.lexicon.data;

import se.lexicon.model.Account;

import java.util.Optional;

public interface AccountDao extends GenericDao <Account, Integer>{

    Optional<Account> findByAccountNumber (String accountNumber);
}
