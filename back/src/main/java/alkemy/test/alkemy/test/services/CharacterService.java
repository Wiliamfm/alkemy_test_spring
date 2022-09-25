package alkemy.test.alkemy.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.test.alkemy.test.repositories.CharacterRepository;
import alkemy.test.alkemy.test.Mapper.CharacterMapper;
import alkemy.test.alkemy.test.dao.CharacterDAO;
import alkemy.test.alkemy.test.entities.Character;;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterMapper mapper;
    
    public List<CharacterDAO> getAll(){
        List<Character> characters= (List<Character>) characterRepository.findAll();
        return mapper.toCharactersDAO(characters);
    }

    public CharacterDAO create(CharacterDAO characterDAO){
        return mapper.toCharacterDAO(characterRepository.save(mapper.toCharacter(characterDAO)));
    }
}
