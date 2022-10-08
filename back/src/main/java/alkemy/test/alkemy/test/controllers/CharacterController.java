package alkemy.test.alkemy.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alkemy.test.alkemy.test.dtos.AbstractResponse;
import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.dtos.ErrorDTO;
import alkemy.test.alkemy.test.services.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    
    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAll(){
        return new ResponseEntity<List<CharacterDTO>>(characterService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<? extends AbstractResponse> create(@RequestBody CharacterDTO characterDAO){
        try{
            return new ResponseEntity<CharacterDTO>(characterService.create(characterDAO), HttpStatus.CREATED);
        }catch(IllegalArgumentException illegalArgumentException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(illegalArgumentException.getMessage()), HttpStatus.NOT_FOUND);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}