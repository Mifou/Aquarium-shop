package aquarium.shop.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, Long> {
    List<OrderDetails> findAll();
}
