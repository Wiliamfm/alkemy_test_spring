package alkemy.test.alkemy.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    private ResponseEntity<? extends Object> create(@RequestBody MovieDTO movieDTO){
        try {
            MovieDTO newMovie= movieService.create(movieDTO);
            if(movieDTO != null){
                return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
            }
            return ResponseEntity.status(HttpStatus.OK).body(new ErrorDTO("Movie no created"));
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<? extends Object> update(@PathVariable("id") int id, @RequestBody MovieDTO movieDTO){
        try{
            if (movieService.getById(id) == null){
                return new ResponseEntity<>(new ErrorDTO("Movie not found"), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<MovieDTO>(movieService.update(id, movieDTO), HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<? extends Object> delete(@PathVariable("id") int id){
        try {
            if(movieService.getById(id) == null){
                return new ResponseEntity<>(new ErrorDTO("Movie not found"), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(movieService.delete(id), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<? extends Object> getById(@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(movieService.getById(id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }   

}
