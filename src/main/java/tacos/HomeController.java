package tacos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tacos.data.IngredientRepository;

//@Controller
@RestController
@RequestMapping("/api/tacos")
@CrossOrigin(origins = "*") // dozvoli frontend-u da pristupa
@Slf4j
public class HomeController {

	@Autowired
	IngredientRepository ingredientRepository;
	
	
	@GetMapping
	public String home() {
		
//		Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
//		log.debug("Prije inserta");
//		flourTortilla = ingredientRepository.save(flourTortilla);
//		log.debug("Nakon inserta");
		

		System.out.println("Pozivam metodu");
		Optional<Ingredient> opt = ingredientRepository.findById("COTO");
		Ingredient ing = opt.get();
		log.info(ing.toString());
		
		return "home";

	}
	
}
