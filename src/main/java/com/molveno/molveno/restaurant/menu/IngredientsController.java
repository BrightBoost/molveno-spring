package com.molveno.molveno.restaurant.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientsController {

    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    DishRepository dishRepository;


    @RequestMapping(value = "/get-ingredients",method = RequestMethod.GET)
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    @RequestMapping(value = "/save-ingredients",method = RequestMethod.POST,consumes = "application/json")
    public boolean saveIngredients(@RequestBody Ingredient ingredient){
        List<Ingredient> s=ingredientRepository.findAll();

        for(Ingredient i:s){

            if (i.getIngredientsName().equals(ingredient.getIngredientsName()))
               return false;
        }
        ingredientRepository.save(ingredient);
        return true;

    }

    @RequestMapping(value = "/check-name",method = RequestMethod.GET)
    public boolean showMessage(@RequestParam String ingredientsName){
        List<Ingredient> s=ingredientRepository.findAll();
        for(Ingredient i:s){

            if (i.getIngredientsName().equals(ingredientsName))
                return false;
        }

        return true;

    }

    @RequestMapping(value = "/edit-ing", method = RequestMethod.POST, consumes = "application/json")
    public void editIng(@RequestBody Ingredient ingredient) {


        Ingredient g = ingredientRepository.findById(ingredient.getId());


        if (!ingredient.getIngredientsName().equals("")) {
            g.setIngredientsName(ingredient.getIngredientsName());
        }
        if (ingredient.getPriceIngredients() != 0.0) {
            g.setPriceIngredients(ingredient.getPriceIngredients());
        }
g.setIngredientQuantityType(ingredient.getIngredientQuantityType());
        ingredientRepository.save(g);


//
        List<Dish> a = dishRepository.findAll();
        for (Dish d : a) {


            double price = 0;
            String x1 = " ";
            List<Double> x2 = new ArrayList<>();
            List<String> x = new ArrayList<>();
            for (int i = 0; i < d.getIngredientsQuan().length(); i++) {
                if (d.getIngredientsQuan().charAt(i) == 'A') {
                    x.add(x1);
                    x1 = " ";

                } else {
                    String s = Character.toString(d.getIngredientsQuan().charAt(i));
                    x1 = (x1 + s).trim();

                }


            }

            for (String s : x) {

                x2.add(Double.parseDouble(s));

            }
            for (int i = 0; i < x2.size(); i++) {
                price = x2.get(i) * d.getIngredients().get(i).getPriceIngredients() + price;

            }


            d.setDishPrice(price);


            dishRepository.save(d);

        }
//


    }





}






