package se.lexicon.data;

import se.lexicon.model.Client;

import java.util.Optional;

public interface ClientDao extends GenericDao<Client, Integer > {

    Optional<Client> findByLastName (String lastName);
}
