package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
//@Table
@Entity
public class Taco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Date createdAt;
	
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taco_order_id")
	private TacoOrder tacoOrder;

//	@NotNull
//	@Size(min = 1, message = "You must choose at least 1 ingredient")
//	private List<Ingredient> ingredients;

	@Size(min = 1, message = "You must choose at least 1 ingredient")

	//	private List<IngredientRef> ingredients = new ArrayList<>();
	@ManyToMany()
	@JoinTable
	 ( name = "ingredient_ref"
	 , joinColumns = @JoinColumn (name = "taco_id")
	 , inverseJoinColumns = @JoinColumn (name = "ingredient_id")
	 )
	private List<Ingredient> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient ingredient) {
//		this.ingredients.add(new IngredientRef(taco.getId()));
		this.ingredients.add(ingredient);
System.out.println("Dodan ingredient: " + ingredient);
System.out.println("Sada ima ingredienata: " + this.ingredients.size());

	}	
	

}