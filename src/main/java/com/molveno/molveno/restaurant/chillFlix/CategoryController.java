package com.molveno.molveno.restaurant.chillFlix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ShowRepository showRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-category", method = RequestMethod.GET)
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/save-category", method = RequestMethod.POST, consumes = "application/json")
    public void saveCategory(@RequestBody Category category) {

        List<Category> c=categoryRepository.findAll();
        if(categoryRepository.findAll().isEmpty()){
            categoryRepository.save(category);
            return;
        }
        for(Category category1:c){

            if (category1.getName().equalsIgnoreCase(category.getName())){
                return;

            }
                categoryRepository.save(category);
        }




    }

    @RequestMapping(value = "/check-categoryName",method = RequestMethod.GET)
    public boolean showMessage(@RequestParam String name){
        List<Category> c=categoryRepository.findAll();
        for(Category category:c){

            if (category.getName().equals(name))
                return false;
        }

        return true;

    }






    @RequestMapping(value = "/delete-category", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteCategory(@RequestBody Category category) {
        categoryRepository.deleteById(category.getId());

    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST, consumes = "application/json")
    public void editCategory(@RequestBody Category category) {


        Category g = categoryRepository.findById(category.getId());


        if (!category.getName().equals("")) {
            g.setName(category.getName());
        }
        if (category.getShows() == null) {

            for (Show c : g.getShows()) {

                c.setMovieCategory(category.getName());
                showRepository.save(c);
            }


        }

        categoryRepository.save(g);

    }





}
