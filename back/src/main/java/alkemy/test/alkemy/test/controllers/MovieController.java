package alkemy.test.alkemy.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import alkemy.test.alkemy.test.dtos.ErrorDTO;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.services.MovieService;

@RestController
@RequestMapping("/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<? extends Object> getAll(@RequestParam(required = false) String title, @RequestParam(required = false) Integer genre, @RequestParam(required = false) String order){
        try{
            List<MovieDTO> movies = new ArrayList<MovieDTO>();
            if(title != null){
                movies.addAll(movieService.getByTitle(title));
            }if (genre != null){
                movies.addAll(movieService.getByGenre(genre));
            }if (order != null){
                movies.addAll(movieService.getByDate(order));
            }if (title == null && genre == null && order == null){
                return new ResponseEntity<List<MovieDTO>>(movieService.getAll(), HttpStatus.OK);
            }
            return new ResponseEntity<List<MovieDTO>>(movies, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
