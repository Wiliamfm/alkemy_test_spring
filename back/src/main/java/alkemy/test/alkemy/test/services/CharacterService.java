package alkemy.test.alkemy.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.test.alkemy.test.repositories.CharacterRepository;
import alkemy.test.alkemy.test.Mapper.CharacterMapper;
import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.entities.Character;;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterMapper mapper;

    public CharacterDTO getById(int id){
        return mapper.toCharacterDTO(characterRepository.findById(id).map(character -> {
            return character;
        }).orElse(null));
    }
    
    public List<CharacterDTO> getAll(){
        List<Character> characters= (List<Character>) characterRepository.findAll();
        return mapper.toCharactersDTO(characters);
    }

    public CharacterDTO create(CharacterDTO characterDTO){
        return mapper.toCharacterDTO(characterRepository.save(mapper.toCharacter(characterDTO)));
    }

    public CharacterDTO update(CharacterDTO characterDTO){
        if( getById(mapper.toCharacter(characterDTO).getId()) != null){
            return mapper.toCharacterDTO(characterRepository.save(mapper.toCharacter(characterDTO)));
        }
        return null;
    }

}
