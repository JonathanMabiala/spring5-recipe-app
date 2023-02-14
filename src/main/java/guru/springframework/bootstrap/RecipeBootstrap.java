package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class RecipeBootstrap implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        //Get all the categories of food
        Category american = categoryRepository.findByDescription("American").get();
        Category italian = categoryRepository.findByDescription("Italian").get();
        Category mexican = categoryRepository.findByDescription("Mexican").get();
        Category fastFood = categoryRepository.findByDescription("Fast Food").get();
        log.debug("Got all the categories of food");

        //Get all Units of Measure
        UnitOfMeasure teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure pinch = unitOfMeasureRepository.findByDescription("Pinch").get();
        UnitOfMeasure ounce = unitOfMeasureRepository.findByDescription("Ounce").get();
        UnitOfMeasure clove = unitOfMeasureRepository.findByDescription("Clove").get();
        log.debug("Got all Units of Measures");

        //Create our first recipe (Guacamole)
        log.debug("Creating our first recipe (Guacamole)");
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setSource("ELISE BAUER");
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setPrepTime(10);
        log.debug("Recipe ready (Guacamole)");

        //Create a note
        log.debug("Creating a note");
        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipe(guacamoleRecipe);
        guacamoleNotes.setRecipeNotes("The best guacamole keeps it simple: just ripe avocados and a handful of flavorful mix-ins. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.\n" +
                "\n" +
                "Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) That's over 7 pounds per person. I'm guessing that most of those avocados go into what has become America's favorite dip: guacamole.\n" +
                "\n" +
                "Guacamole: A Classic Mexican Dish\n" +
                "The word \"guacamole\" and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).\n" +
                "\n" +
                "Ingredients for Easy Guacamole\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help balance the richness of the avocado. If you want, add chopped cilantro, chilis, onion, and/or tomato.\n" +
                "\n" +
                "How To Pick Perfectly Ripe Avocados\n" +
                "The trick to making perfect guacamole is using avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and flavorless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be too ripe and not good. In this case, taste test first before using.\n" +
                "\n" +
                "How To Cut an Avocado\n" +
                "To slice open an avocado, cut it in half lengthwise with a sharp chef's knife and twist apart. One side will have the pit. To remove it, you can carefully tap your chef’s knife against the pit and twist to dislodge it (protecting your hand with a towel), or you can cut the avocado into quarters and remove the pit with your fingers or a spoon.\n" +
                "\n" +
                "Other Ways To Use Guacamole\n" +
                "\n" +
                "Guacamole has a role in the kitchen beyond a party dip. It's great scooped on top of nachos and also makes an excellent topping or side for enchiladas, tacos, grilled salmon, or oven-baked chicken.\n" +
                "\n" +
                "Guacamole is great in foods, as well. Try mixing some into a tuna sandwich or your next batch of deviled eggs.\n" +
                "\n" +
                "How To Store Guacamole\n" +
                "Guacamole is best eaten right after it's made. Like apples, avocados start to oxidize and turn brown once they've been cut. That said, the acid in the lime juice you add to guacamole can help slow down that process. And if you store the guacamole properly, you can easily make it a few hours ahead if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn't touch it! Transfer it to a container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days. If the guacamole develops discoloration, you can either scrape off the brown parts and discard, or stir into the rest of the guacamole before serving\n" +
                "\n" +
                "Guacamole Variations\n" +
                "Once you have basic guacamole down, feel free to experiment with variations by adding strawberries, peaches, pineapple, mangoes, or even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with your homemade guacamole!\n" +
                "\n" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don't have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It still tastes great.\n" +
                "Here Are a Few Other Guacamole Recipes to Try\n" +
                "Spicy Three-Chile Guacamole\n" +
                "Strawberry Guacamole\n" +
                "Guacamole with Charred Sweet Corn, Bacon, and Tomato\n" +
                "Copycat Chipotle Guacamole\n" +
                "Bacon and Blue Cheese Guacamole");
        guacamoleRecipe.setNotes(guacamoleNotes);

        //Create Ingredients
        log.debug("Create Ingredients");
        Ingredient avocado = new Ingredient("Avocado",new BigDecimal(2),guacamoleRecipe);
        Ingredient kosherSalt = new Ingredient("kosher salt",new BigDecimal(1/4),teaSpoon,guacamoleRecipe);
        Ingredient  lemonJuice = new Ingredient(" lemon juice",new BigDecimal(1),tableSpoon,guacamoleRecipe);
        Ingredient  mincedRedOnionOrThinlySlicedGreenOnion = new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(4),tableSpoon,guacamoleRecipe);
        Ingredient  serrano  = new Ingredient("serrano (or jalapeño) chilis, stems and seeds removed, minced",new BigDecimal(2),guacamoleRecipe);
        Ingredient  cilantro   = new Ingredient("cilantro (leaves and tender stems), finely chopped",new BigDecimal(2),tableSpoon,guacamoleRecipe);
        Ingredient  blackPepper   = new Ingredient("freshly ground black pepper",pinch,guacamoleRecipe);
        Ingredient  tomato   = new Ingredient("ripe tomato, chopped (optional)",new BigDecimal(1/2),guacamoleRecipe);
        Ingredient  redRadish   = new Ingredient("Red radish or jicama slices for garnish (optional)",new BigDecimal(1),guacamoleRecipe);
        Ingredient  tortillaChips   = new Ingredient("tortillaChips",new BigDecimal(1),guacamoleRecipe);


        //Create set of ingredients
        log.debug("Create set of ingredients");
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(avocado);
        ingredients.add(kosherSalt);
        ingredients.add(lemonJuice);
        ingredients.add(mincedRedOnionOrThinlySlicedGreenOnion);
        ingredients.add(serrano);
        ingredients.add(cilantro);
        ingredients.add(blackPepper);
        ingredients.add(tomato);
        ingredients.add(redRadish);
        ingredients.add(tortillaChips);
        // Add the Ingredients
        guacamoleRecipe.setIngredients(ingredients);

        //guacamole.setImage();
        guacamoleRecipe.setDirection("1- Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 - Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 - Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 - Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "Refrigerate leftover guacamole up to 3 days.\n" +
                "\n" +
                "Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.");

        guacamoleRecipe.setDescription("How to Make the Best Guacamole");
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/#toc-ingredients-for-easy-guacamole");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setCookTime(10);

        //Create Categories
        Set<Category> categories = new HashSet<>();
        categories.add(american);
        guacamoleRecipe.setCategories(categories);


        //Create our Seconde recipe (Spicy Grilled Chicken Tacos)
        Recipe chickenTacosRecipe = new Recipe();
        chickenTacosRecipe.setSource("SALLY VARGAS");
        chickenTacosRecipe.setServings(6);
        chickenTacosRecipe.setPrepTime(20);

        //Create a note
        Notes chickenNotes = new Notes();
        chickenNotes.setRecipe(chickenTacosRecipe);
        chickenNotes.setRecipeNotes("Spicy Grilled Chicken Tacos\n" +
                "Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.\n" +
                "\n" +
                "\n" +
                "We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today's tacos are more purposeful a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well—this green isn't traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that's living!\n" +
                "\n" +
                "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        chickenTacosRecipe.setNotes(chickenNotes);

        //Create Ingredients
        Ingredient ancho = new Ingredient("ancho chili powder",new BigDecimal(2),tableSpoon,chickenTacosRecipe);
        Ingredient oregano = new Ingredient("dried oregano",new BigDecimal(1),teaSpoon,chickenTacosRecipe);
        Ingredient  cumin = new Ingredient("Cumin",new BigDecimal(1),teaSpoon,chickenTacosRecipe);
        Ingredient  sugar = new Ingredient("Sugar",new BigDecimal(1),teaSpoon,chickenTacosRecipe);
        Ingredient  salt  = new Ingredient("kosher salt",new BigDecimal(1/2),teaSpoon,chickenTacosRecipe);
        Ingredient  garlic   = new Ingredient("Garlic, finely chopped",new BigDecimal(1),clove,chickenTacosRecipe);
        Ingredient  zest   = new Ingredient("Finely grated orange zest",tableSpoon,chickenTacosRecipe);
        Ingredient  orangeJuice   = new Ingredient("Fresh-squeezed orange juice",new BigDecimal(1/2),chickenTacosRecipe);
        Ingredient  oliveOil   = new Ingredient("Olive Oil",tableSpoon,chickenTacosRecipe);
        Ingredient  chiken   = new Ingredient("skinless, boneless chicken thighs",new BigDecimal(6),chickenTacosRecipe);

        //Create set of ingredients
        Set<Ingredient> chickenIngredients = new HashSet<>();
        chickenIngredients.add(ancho);
        chickenIngredients.add(oregano);
        chickenIngredients.add(cumin);
        chickenIngredients.add(sugar);
        chickenIngredients.add(salt);
        chickenIngredients.add(garlic);
        chickenIngredients.add(zest);
        chickenIngredients.add(orangeJuice);
        chickenIngredients.add(oliveOil);
        chickenIngredients.add(chiken);

        // Add the Ingredients

        chickenTacosRecipe.setIngredients(chickenIngredients);

        //guacamole.setImage();
        chickenTacosRecipe.setDirection("1 - Prepare the grill:\n" +
                "Prepare either a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2- Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 - Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 - Thin the sour cream with milk:\n" +
                "Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle.\n" +
                "\n" +
                "5 - Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "6 - Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.");

        chickenTacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        chickenTacosRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenTacosRecipe.setDifficulty(Difficulty.MODERATE);
        chickenTacosRecipe.setCookTime(15);

        guacamoleRecipe.getCategories().add(american);


        recipeRepository.save(guacamoleRecipe);
        recipeRepository.save(chickenTacosRecipe);


    }
}
