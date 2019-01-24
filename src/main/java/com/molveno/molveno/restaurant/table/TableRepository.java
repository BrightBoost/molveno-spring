package com.molveno.molveno.restaurant.table;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends CrudRepository<Tablee, Long> {
    List<Tablee> findAll();

}
