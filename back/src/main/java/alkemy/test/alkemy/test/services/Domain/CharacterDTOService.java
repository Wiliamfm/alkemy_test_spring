package alkemy.test.alkemy.test.services.Domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alkemy.test.alkemy.test.repositories.CharacterRepository;
import alkemy.test.alkemy.test.Mapper.CharacterMapper;
import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.entities.Character;;

@Service
public class CharacterDTOService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterMapper mapper;

    public CharacterDTO getById(int id){
        return mapper.toCharacterDTO(characterRepository.findById(id).map(character -> {
            return character;
        }).orElseGet(null));
    }

    public List<CharacterDTO> getAllByName(String name){
        return mapper.toCharactersDTO(characterRepository.findByNameContainingIgnoreCase(name));
    }

    public List<CharacterDTO> getByAge(int age){
        return mapper.toCharactersDTO(characterRepository.findByAge(age));
    }

    public List<CharacterDTO> getByMovie(int movieId){
        return mapper.toCharactersDTO(characterRepository.findByMovies(movieId));
    }

    public List<CharacterDTO> getAll(){
        List<Character> characters= (List<Character>) characterRepository.findAll();
        return mapper.toCharactersDTO(characters);
    }

    @Transactional
    public CharacterDTO create(CharacterDTO characterDTO) throws IllegalArgumentException{
        return mapper.toCharacterDTO(characterRepository.save(mapper.toCharacter(characterDTO)));
    }

    @Transactional
    public CharacterDTO update(int id, CharacterDTO characterDTO) throws IllegalArgumentException{
        Character character= mapper.toCharacter(getById(id));
        character.setId(id);
        character.setImage(characterDTO.getImage());
        character.setName(characterDTO.getName());
        character.setAge(characterDTO.getAge());
        character.setWeight(characterDTO.getWeight());
        character.setHistory(characterDTO.getHistory());
        return mapper.toCharacterDTO(characterRepository.save(character));
    }

    @Transactional
    public CharacterDTO delete(int id) throws IllegalArgumentException{
        CharacterDTO character= getById(id);
        characterRepository.deleteById(id);
        return character;
    }

}
