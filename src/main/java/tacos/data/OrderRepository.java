/*package tacos.data;

import java.util.Optional;
import tacos.TacoOrder;

public interface OrderRepository {
	TacoOrder save(TacoOrder order);
}
*/

package tacos.data;

import org.springframework.data.repository.CrudRepository;

import tacos.TacoOrder;

public interface OrderRepository 
         extends CrudRepository<TacoOrder, Long> {

}
