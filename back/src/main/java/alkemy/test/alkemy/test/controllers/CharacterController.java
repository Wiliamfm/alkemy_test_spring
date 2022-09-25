package alkemy.test.alkemy.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alkemy.test.alkemy.test.dao.CharacterDAO;
import alkemy.test.alkemy.test.services.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    
    @GetMapping
    private ResponseEntity<List<CharacterDAO>> getAll(){
        return new ResponseEntity<List<CharacterDAO>>(characterService.getAll(), HttpStatus.OK);
    }
}