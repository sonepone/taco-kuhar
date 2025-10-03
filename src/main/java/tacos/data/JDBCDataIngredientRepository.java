package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

public interface JDBCDataIngredientRepository extends CrudRepository<Ingredient, String> {
}