package se.lexicon.service;

public interface Transaction {
    boolean transfer (Integer authorizedClientId, double amount, String fromAccountNumber, String toAccountNumber);
    boolean verifyClient (Integer authorizedClientId);
}
