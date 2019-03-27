package com.molveno.molveno.restaurant.chillFlix;

import com.molveno.molveno.restaurant.guest.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long>{
    List<Category> findAll();

    Category findById(long id);
}
