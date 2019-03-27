package com.molveno.molveno.restaurant.chillFlix;

import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/get-show", method = RequestMethod.GET)
    public List<Show> getAll() {
        return showRepository.findAll();
    }

    @RequestMapping(value = "/save-show", method = RequestMethod.POST, consumes = "application/json")
    public void saveGuest(@RequestBody Show show) {

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


    @RequestMapping(value = "/edit-show", method = RequestMethod.POST, consumes = "application/json")
    public void editShow(@RequestBody Show show) {


        Show s = showRepository.findById(show.getId());


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

    @RequestMapping(value = "/delete-show", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteShow(@RequestBody Show show) {
        Show s = showRepository.findById(show.getId());
        for (Category c : categoryRepository.findAll()) {

            if (c.getName().equals(s.getMovieCategory())) {
                List<Show> shows = c.getShows();
                shows.remove(s);
                c.setShows(shows);
                // categoryRepository.save(c);
            }


            showRepository.deleteById(s.getId());

        }


    }
}