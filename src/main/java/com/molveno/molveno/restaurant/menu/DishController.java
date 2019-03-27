package com.molveno.molveno.restaurant.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DishController {

    @Autowired
    DishRepository dishRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @RequestMapping(value = "/get-dish", method = RequestMethod.GET)
    public List<Dish> getDishes() {



/*
List<Dish> a =dishRepository.findAll();
for(Dish d:a){


double price =0;
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
    for(int i=0;i<x2.size();i++){
        price= x2.get(i)*d.getIngredients().get(i).getPriceIngredients() +price;

    }


    d.setDishPrice(price);



    dishRepository.save(d);

}








*/
Period a = Period.ofDays(10);
LocalDate a1 = LocalDate.now();
a1=a1.minus(a);


        return dishRepository.findAll();


    }

    @RequestMapping(value = "/save-dish", method = RequestMethod.POST, consumes = "application/json")
    public void saveDish(@RequestBody Dish dish) {
       double price =0;
        String x1 = " ";
        List<Double> x2 = new ArrayList<>();
        List<String> x = new ArrayList<>();
        for (int i = 0; i < dish.getIngredientsQuan().length(); i++) {
            if (dish.getIngredientsQuan().charAt(i) == 'A') {
                x.add(x1);
                x1 = " ";

            } else {
                String s = Character.toString(dish.getIngredientsQuan().charAt(i));
                x1 = (x1 + s).trim();

            }


        }

        for (String s : x) {

            x2.add(Double.parseDouble(s));

        }

        for(int i=0;i<x2.size();i++){
            price= x2.get(i)*dish.getIngredients().get(i).getPriceIngredients() +price;

        }



        dish.setDishPrice(price);







        dishRepository.save(dish);
    }

    public static double roundToHalf(double d) {
        return Math.round(d * 2) / 2.0;
    }
}
