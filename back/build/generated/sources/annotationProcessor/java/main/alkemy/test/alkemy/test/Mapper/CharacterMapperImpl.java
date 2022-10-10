package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Character;
import alkemy.test.alkemy.test.entities.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-09T19:42:37-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class CharacterMapperImpl implements CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<CharacterDTO> toCharactersDTO(List<Character> characters) {
        if ( characters == null ) {
            return null;
        }

        List<CharacterDTO> list = new ArrayList<CharacterDTO>( characters.size() );
        for ( Character character : characters ) {
            list.add( toCharacterDTO( character ) );
        }

        return list;
    }

    @Override
    public Character toCharacter(CharacterDTO characterDTO) {
        if ( characterDTO == null ) {
            return null;
        }

        Character character = new Character();

        character.setImage( characterDTO.getImage() );
        character.setName( characterDTO.getName() );
        character.setAge( characterDTO.getAge() );
        character.setWeight( characterDTO.getWeight() );
        character.setHistory( characterDTO.getHistory() );
        character.setMovies( movieDTOListToMovieList( characterDTO.getMovies() ) );

        return character;
    }

    protected List<Movie> movieDTOListToMovieList(List<MovieDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Movie> list1 = new ArrayList<Movie>( list.size() );
        for ( MovieDTO movieDTO : list ) {
            list1.add( movieMapper.toMovie( movieDTO ) );
        }

        return list1;
    }
}
