package alkemy.test.alkemy.test.Mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.entities.Character;

@Mapper(componentModel = "spring", uses = MovieMapper.class)
public interface CharacterMapper {

    CharacterDTO toCharacterDTO(Character character);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "weight", ignore = true)
    @Mapping(target = "history", ignore = true)
    @Mapping(target = "movies", ignore = true)
    CharacterDTO tCharacterDTO(String name, String image);

    List<CharacterDTO> toCharactersDTO(List<Character> characters);

    @InheritInverseConfiguration(name = "toCharacterDTO")
    @Mapping(target = "id", ignore = true)
    Character toCharacter(CharacterDTO characterDTO);

    @InheritInverseConfiguration
    List<Character> toCharacters(List<CharacterDTO> characters);

    //default CharacterDTO toCharacterDTO(Character character, String o){
        //return new CharacterDTO(character.getImage(), character.getName());
    //}

    //default CharacterDTO toCharacterDTO(Character character){
        //return new CharacterDTO(character.getImage(), character.getName(), character.getAge(), character.getWeight(), character.getHistory(), null);
    //}
    
}
