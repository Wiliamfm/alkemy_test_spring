package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dao.CharacterDAO;
import alkemy.test.alkemy.test.entities.Character;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-25T18:35:07-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterDAO toCharacterDAO(Character character) {
        if ( character == null ) {
            return null;
        }

        String image = null;
        String name = null;

        image = character.getImage();
        name = character.getName();

        CharacterDAO characterDAO = new CharacterDAO( image, name );

        if ( character.getAge() != null ) {
            characterDAO.setAge( character.getAge() );
        }
        if ( character.getWeight() != null ) {
            characterDAO.setWeight( character.getWeight() );
        }
        characterDAO.setHistory( character.getHistory() );

        return characterDAO;
    }

    @Override
    public List<CharacterDAO> toCharactersDAO(List<Character> characters) {
        if ( characters == null ) {
            return null;
        }

        List<CharacterDAO> list = new ArrayList<CharacterDAO>( characters.size() );
        for ( Character character : characters ) {
            list.add( toCharacterDAO( character ) );
        }

        return list;
    }

    @Override
    public Character toCharacter(CharacterDAO characterDAO) {
        if ( characterDAO == null ) {
            return null;
        }

        Character character = new Character();

        character.setImage( characterDAO.getImage() );
        character.setName( characterDAO.getName() );
        character.setAge( characterDAO.getAge() );
        character.setWeight( characterDAO.getWeight() );
        character.setHistory( characterDAO.getHistory() );

        return character;
    }
}
