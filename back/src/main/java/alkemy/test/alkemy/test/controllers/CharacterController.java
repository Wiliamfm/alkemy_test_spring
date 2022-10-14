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

import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.dtos.ErrorDTO;
import alkemy.test.alkemy.test.services.CharacterService;

@RestController
@RequestMapping("/characters")
@CrossOrigin
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    
    @GetMapping
    public ResponseEntity<? extends Object> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age, @RequestParam(required = false) Integer movieId){
        try{
            List<CharacterDTO> characters = new ArrayList<CharacterDTO>();
            if(name != null){
                characters.addAll(characterService.getByName(name));
            }if (age != null){
                characters.addAll(characterService.getByAge(age));
            }if (movieId != null){
                characters.addAll(characterService.getByMovie(movieId));
            }if (name == null && age == null && movieId == null){
                return new ResponseEntity<List<CharacterDTO>>(characterService.getAll(), HttpStatus.OK);
            }
            return new ResponseEntity<List<CharacterDTO>>(characters, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<? extends Object> getById(@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(characterService.getById(id), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<? extends Object> create(@RequestBody CharacterDTO characterDAO){
        try{
            return new ResponseEntity<CharacterDTO>(characterService.create(characterDAO), HttpStatus.CREATED);
        }catch(IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<? extends Object> update(@PathVariable("id") int id, @RequestBody CharacterDTO characterDTO){
        try{
            if (characterService.getById(id) == null){
                return new ResponseEntity<>(new ErrorDTO("Character not found"), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<CharacterDTO>(characterService.update(id, characterDTO), HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<? extends Object> delete(@PathVariable("id") int id){
        try {
            if(characterService.getById(id) == null){
                return new ResponseEntity<>(new ErrorDTO("Character not found"), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(characterService.delete(id), HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}