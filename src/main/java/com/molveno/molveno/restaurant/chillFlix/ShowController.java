package com.molveno.molveno.restaurant.chillFlix;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.guest.GuestRepository;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-show", method = RequestMethod.GET)
    public List<Show> getAll() {
        return showRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/save-show", method = RequestMethod.POST, consumes = "application/json")
    public void saveShow(@RequestBody Show show) {
        System.out.println("Received call to save show");
        show.setFavoriteCounter(0);
        show.setTime(LocalDateTime.of(2015,1,1,2,3,4,2));
        show.setCounter(0);

        showRepository.save(show);

        for (Category c : categoryRepository.findAll()) {

            if (c.getName().equals(show.getMovieCategory())) {
                List<Show> shows = c.getShows();
                shows.add(show);
                c.setShows(shows);
                categoryRepository.save(c);
            }


        }


    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/edit-show", method = RequestMethod.POST, consumes = "application/json")
    public void editShow(@RequestBody Show show) {


        Show s = showRepository.findById(show.getId());
           s.setFavoriteStatus(show.isFavoriteStatus());
           s.setTime(show.getTime());
          s.setCounter(show.getCounter());
          s.setFavoriteCounter(show.getFavoriteCounter());

        if (!show.getUrl().equals("")) {
            s.setUrl(show.getUrl());
        }
        if (!show.getDirector().equals("")) {
            s.setDirector(show.getDirector());
        }
        if (!show.getReleaseDate().equals("")) {
            s.setReleaseDate(show.getReleaseDate());
        }
        if (!show.getTitle().equals("")) {
            s.setTitle(show.getTitle());
        }
        if (!show.getDescription().equals("")) {
            s.setDescription(show.getDescription());
        }
        if (!s.getMovieCategory().equals(show.getMovieCategory())) {
            for (Category c : categoryRepository.findAll()) {


                if (c.getName().equals(s.getMovieCategory())) {
                    List<Show> shows = c.getShows();
                    shows.remove(s);
                    c.setShows(shows);
                    categoryRepository.save(c);

                }
            }
            s.setMovieCategory(show.getMovieCategory());
            for (Category c : categoryRepository.findAll()) {


                if (c.getName().equals(s.getMovieCategory())) {
                    List<Show> shows = c.getShows();
                    showRepository.save(s);
                    shows.add(s);
                    c.setShows(shows);
                    categoryRepository.save(c);

                }
            }

        }

        showRepository.save(s);

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/delete-show", method = RequestMethod.POST, consumes = "application/json")
    public void deleteShow(@RequestBody Show show) {
        System.out.println("We want to delete show " + show.getId());
        Show s = showRepository.findById(show.getId());
        if(s == null) System.out.println("Show is null!" );
        if(s != null) System.out.println("Show category is " + s.getMovieCategory() );
        for (Category c : categoryRepository.findAll()) {

            if (c.getName().equals(s.getMovieCategory())) {
                System.out.println("We found a match for " + c.getName());
                List<Show> shows = c.getShows();
                shows.remove(s);
                c.setShows(shows);
                categoryRepository.save(c);
                showRepository.deleteById(s.getId());
                return;
            }




        }


    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-one-show/{id}", method = RequestMethod.GET)
    public Show getOneById(@PathVariable long id) {


        return showRepository.findById(id);


    }




    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-favorite-shows", method = RequestMethod.GET)
    public List<Show> getFavoriteShows() {
        List<Show> x = new ArrayList<>();
        for(Show z: showRepository.findAll()){
            if(z.isFavoriteStatus()==true){
                x.add(z);
            }

        }

        return x;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-recently", method = RequestMethod.GET)
    public List<Show> getRecently() {
        List<Show> s=showRepository.findAll();
        s.sort(Comparator.comparing(Show::getTime).reversed());
        List<Show> x= new ArrayList<>();
      if(s.size()<=5){return s;}

      else {

          for(int i=0; i<=4; i++){
              x.add(s.get(i));
          }
          return x;
      }




    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-most-viewd", method = RequestMethod.GET)
    public List<Show> getMostViewd() {
        List<Show> s=showRepository.findAll();
        s.sort(Comparator.comparing(Show::getCounter).reversed());
        List<Show> x= new ArrayList<>();
        if(s.size()<=5){return s;}

        else {

            for(int i=0; i<=4; i++){
                x.add(s.get(i));
            }
            return x;
        }




    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-liked-shows", method = RequestMethod.GET)
    public List<Show> getMostLiked() {
        List<Show> s=showRepository.findAll();
        s.sort(Comparator.comparing(Show::getFavoriteCounter).reversed());
        List<Show> x= new ArrayList<>();
        if(s.size()<=5){return s;}

        else {

            for(int i=0; i<=4; i++){
                x.add(s.get(i));
            }
            return x;
        }





    }
}