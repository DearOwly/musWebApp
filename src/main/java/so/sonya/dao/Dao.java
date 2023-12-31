package so.sonya.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T, K>{

    T save(T model);
    Optional<T> findById(K id);
    List<T> findAll();
    boolean delete(K id);

}
