package alkemy.test.alkemy.test.Mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.entities.Character;

@Mapper(componentModel = "spring", uses = MovieMapper.class)
public interface CharacterMapper {

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "age", target = "age"),
        @Mapping(source = "weight", target = "weight"),
        @Mapping(source = "history", target = "history"),
        @Mapping(source = "movies", target = "movies")
    })
    CharacterDTO toCharacterDTO(Character character);

    List<CharacterDTO> toCharactersDTO(List<Character> characters);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Character toCharacter(CharacterDTO characterDTO);
    
}
