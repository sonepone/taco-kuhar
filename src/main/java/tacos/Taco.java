package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table
public class Taco {
	
	@Id
	Long id;
	Date createdAt;
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;

//	@NotNull
//	@Size(min = 1, message = "You must choose at least 1 ingredient")
//	private List<Ingredient> ingredients;

	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<IngredientRef> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient taco) {
		this.ingredients.add(new IngredientRef(taco.getId()));
	}	
	

}