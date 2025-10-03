package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.TacoOrder;

public interface JDBCDataOrderRepository extends CrudRepository<TacoOrder, Long> {
}