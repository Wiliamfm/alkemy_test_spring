package alkemy.test.alkemy.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.test.alkemy.test.repositories.CharacterRepository;
import alkemy.test.alkemy.test.dao.CharacterDAO;;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;
    
    public List<CharacterDAO> getAll(){
        List<CharacterDAO> characters= new ArrayList<>();
        characterRepository.findAll().forEach(character -> {
            characters.add(new CharacterDAO(character.getImage(), character.getName()));
        });
        return characters;
    }
}
