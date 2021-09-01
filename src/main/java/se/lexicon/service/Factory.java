package se.lexicon.service;

import se.lexicon.model.Account;
import se.lexicon.model.Client;

import java.util.Optional;

public interface Factory {

    Optional<Account> createAccount();
    Optional<Account> createAccount(int id);
    Optional<Client> createClient(String firstName, String lastName);
    Optional<Client> createClient(int id, String firstName, String lastName);
}
