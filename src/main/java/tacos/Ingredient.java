package tacos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.domain.Persistable;
//import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tacos.Ingredient.Type;

@Data
//@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient /*implements Persistable<String>*/ {
	@Id
	private String id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Type type;

//	@Override
//	public boolean isNew() {
//		return true;
//	}

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	
}