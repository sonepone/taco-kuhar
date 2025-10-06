package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tacos.data.IngredientRepository;
//import tacos.data.JDBCDataIngredientRepository;
//import tacos.data.JDBCDataOrderRepository;
import tacos.data.OrderRepository;

//@Controller
@RestController
@RequestMapping("/api/tacos")
@CrossOrigin(origins = "*") // dozvoli frontend-u da pristupa
@Slf4j
public class HomeController {

	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	OrderRepository orderRepository;

//	@Autowired
//	JDBCDataIngredientRepository ingredientRepository;
//	
//	@Autowired
//	JDBCDataOrderRepository orderRepository;
	
	
	
	@GetMapping
	public String home() {
		
//		Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
//		log.debug("Prije inserta");
//		flourTortilla = ingredientRepository.save(flourTortilla);
//		log.debug("Nakon inserta");
		
		TacoOrder tacoOrder = new TacoOrder();
		tacoOrder.setDeliveryName("Nebojša");
		tacoOrder.setDeliveryStreet("Kordunaska 16");
		tacoOrder.setDeliveryCity("Banja Luka");
		tacoOrder.setDeliveryState("RS");
		tacoOrder.setDeliveryZip("78000");
		tacoOrder.setCcCVV("778");
		tacoOrder.setCcExpiration("07/28");
		tacoOrder.setCcNumber("12345678901234");
		tacoOrder.setPlacedAt(new Date());
		
		Taco taco1 = new Taco();
		taco1.setName("Novi taco - SEDMI");
		taco1.setCreatedAt(new Date());
//		List<IngredientRef> lista = new ArrayList<IngredientRef>();
//		lista.add(new IngredientRef("COTO"));
//		lista.add(new IngredientRef("GRBF"));
//		lista.add(new IngredientRef("CHED"));
//		lista.add(new IngredientRef("TMTO"));
		List<Ingredient> lista = new ArrayList<Ingredient>();
		lista.add(ingredientRepository.findById("COTO").get());
		lista.add(ingredientRepository.findById("GRBF").get());
		lista.add(ingredientRepository.findById("CHED").get());
		lista.add(ingredientRepository.findById("TMTO").get());
		
		
		taco1.setIngredients(lista);
		taco1.setTacoOrder(tacoOrder);

		
		Taco taco2 = new Taco();
		taco2.setName("Ovo bi bio OSMI");
		taco2.setCreatedAt(new Date());
//		List<IngredientRef> lista2 = new ArrayList<IngredientRef>();
//		lista2.add(new IngredientRef("FLTO"));
//		lista2.add(new IngredientRef("CARN"));
//		lista2.add(new IngredientRef("JACK"));
//		lista2.add(new IngredientRef("LETC"));
//		taco2.setIngredients(lista2);

		List<Ingredient> lista2 = new ArrayList<Ingredient>();
		lista2.add(ingredientRepository.findById("FLTO").get());
		lista2.add(ingredientRepository.findById("CARN").get());
		lista2.add(ingredientRepository.findById("JACK").get());
		lista2.add(ingredientRepository.findById("LETC").get());
		taco2.setIngredients(lista2);
		taco2.setTacoOrder(tacoOrder);
		
		tacoOrder.addTaco(taco1);
		tacoOrder.addTaco(taco2);
		
		orderRepository.save(tacoOrder);
		

		System.out.println("Pozivam metodu");
		Optional<Ingredient> opt = ingredientRepository.findById("COTO");
		Ingredient ing = opt.get();
		log.info(ing.toString());
		
		return "home";

	}
	
}
