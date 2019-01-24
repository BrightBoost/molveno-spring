package com.molveno.molveno.restaurant.table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TableController {


        @Autowired
        private TableRepository tableRepository;

        @RequestMapping(value = "/catch", method = RequestMethod.GET)
        public List<Tablee> getAll() {
            return tableRepository.findAll();
        }


    }

