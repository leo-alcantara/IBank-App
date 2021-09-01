package se.lexicon.data;

import java.util.Collection;
import java.util.Optional;

public interface GenericDao <T, ID> {

    Optional<T> create(T t);
    boolean delete(ID id);
    Collection<T> findAll();
    Optional<T> findById(ID id);
    boolean update(T t);
}
