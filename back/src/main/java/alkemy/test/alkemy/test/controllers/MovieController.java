package alkemy.test.alkemy.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alkemy.test.alkemy.test.dtos.ErrorDTO;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    private ResponseEntity<? extends Object> getAll(@PathVariable(name = "title", required = false) String title, @PathVariable(name = "genre", required = false) Integer genreId, @PathVariable(name = "order", required = false) String order){
        try {
            List<MovieDTO> movies= new ArrayList<>();
            if(title == null && genreId == null && order == null){
                return ResponseEntity.ok(movieService.getAll());
            }if (title != null){
                movies.addAll(movieService.getByTitle(title));
            }if (genreId != null){
                movies.addAll(movieService.getByGenre(genreId));
            }if (order != null){
                movies.addAll(movieService.getByOrderCreationDate(order));
            }
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.ok(new ErrorDTO(e.getMessage()));
        }
    }
    
}
