package se.lexicon.data;

import se.lexicon.model.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {

    Collection<Client> clientStorage = null;

    public ClientDaoImpl() {
        this.clientStorage = new HashSet<>();
    }

    @Override
    public Optional<Client> findByLastName(String lastName) {
        return clientStorage.stream()
                .filter(client -> client.getClientLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }

    @Override
    public Optional<Client> create(Client client) {
        clientStorage.add(client);
        return findById(client.getClientId());
    }

    @Override
    public boolean delete(Integer id) {
        return clientStorage.removeIf(client -> client.getClientId() == id);
    }

    @Override
    public Collection<Client> findAll() {
        return clientStorage;
    }

    @Override
    public Optional<Client> findById(Integer id) {
        return clientStorage.stream()
                .filter(client -> client.getClientId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Client client) {
        clientStorage.removeIf(c -> c.getClientId() == client.getClientId());
        return clientStorage.add(client);
    }
}
