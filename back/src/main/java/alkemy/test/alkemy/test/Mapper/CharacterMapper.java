package alkemy.test.alkemy.test.Mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import alkemy.test.alkemy.test.dao.CharacterDAO;
import alkemy.test.alkemy.test.entities.Character;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mappings({
        @Mapping(source = "image", target = "image"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "age", target = "age"),
        @Mapping(source = "weight", target = "weight"),
        @Mapping(source = "history", target = "history")
    })
    CharacterDAO toCharacterDAO(Character character);

    List<CharacterDAO> toCharactersDAO(List<Character> characters);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "id", ignore = true)
    })
    Character toCharacter(CharacterDAO characterDAO);
    
}
