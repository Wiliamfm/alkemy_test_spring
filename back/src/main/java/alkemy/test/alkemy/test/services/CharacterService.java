package alkemy.test.alkemy.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.test.alkemy.test.repositories.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;
    
    public alkemy.test.alkemy.test.entities.Character getByName(String name){
        return characterRepository.findByName(name).map(c -> {
            return c;
        }).orElse(null);
    }
}
