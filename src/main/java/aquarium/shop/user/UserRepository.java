package aquarium.shop.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Long> {
    List<UserDetails> findAll();
}
