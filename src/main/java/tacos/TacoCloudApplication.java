package tacos;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tacos.data.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}
	
	@Bean
	//public CommandLineRunner dataLoader(IngredientRepository repo) {
	public ApplicationRunner dataLoader(IngredientRepository repo) {
		return args -> {

			System.out.println(args);
			System.out.println("klasa: " + args.getClass());

			Set<String> names = args.getOptionNames();
			for (String element : names) {
//	System.out.println(">" + element + "<");
				List<String> optionValues = args.getOptionValues(element);

				for (String optionValue : optionValues) {
					System.out.println(">" + element + "<; optionValue >" + optionValue + "<");
				}
			}
			System.out.println("#############################################################################");			
			System.out.println("Parametri se setuju u 'Debug Configurations...' tj. u 'Run Configurations...'");
			System.out.println("Aplikacije se moze pokrenuti sa komandne linije sa:");
			System.out.println("$ mvn spring-boot:run -Dspring-boot.run.arguments=\"--arg1=value1 --arg2=value2 --version=1.0.0.4 --opcije=prva --opcije=druga\"");
			System.out.println("ili");
			System.out.println("$ java -jar target/taco-cloud-0.0.1-SNAPSHOT.jar");
			System.out.println("#############################################################################");

//for(String element : args)
//{
//	System.out.println(">" + element + "<");
//}

//			repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
//			repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
//			repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
//			repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
//			repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
//			repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
//			repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
//			repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
//			repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
//			repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
		};
	}

}
