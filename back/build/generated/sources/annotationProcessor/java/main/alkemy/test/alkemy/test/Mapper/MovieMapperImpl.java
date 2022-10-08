package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Character;
import alkemy.test.alkemy.test.entities.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-08T17:02:12-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setImage( movie.getImage() );
        movieDTO.setTitle( movie.getTitle() );
        movieDTO.setCreationDate( movie.getCreationDate() );
        if ( movie.getCalification() != null ) {
            movieDTO.setCalification( movie.getCalification() );
        }
        movieDTO.setCharacters( characterListToCharacterDTOList( movie.getCharacters() ) );

        return movieDTO;
    }

    @Override
    public Movie toMovie(MovieDTO movieDAO) {
        if ( movieDAO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setImage( movieDAO.getImage() );
        movie.setTitle( movieDAO.getTitle() );
        movie.setCreationDate( movieDAO.getCreationDate() );
        movie.setCalification( movieDAO.getCalification() );
        movie.setCharacters( characterDTOListToCharacterList( movieDAO.getCharacters() ) );

        return movie;
    }

    protected List<MovieDTO> movieListToMovieDTOList(List<Movie> list) {
        if ( list == null ) {
            return null;
        }

        List<MovieDTO> list1 = new ArrayList<MovieDTO>( list.size() );
        for ( Movie movie : list ) {
            list1.add( toMovieDTO( movie ) );
        }

        return list1;
    }

    protected CharacterDTO characterToCharacterDTO(Character character) {
        if ( character == null ) {
            return null;
        }

        String image = null;
        String name = null;

        image = character.getImage();
        name = character.getName();

        CharacterDTO characterDTO = new CharacterDTO( image, name );

        if ( character.getAge() != null ) {
            characterDTO.setAge( character.getAge() );
        }
        if ( character.getWeight() != null ) {
            characterDTO.setWeight( character.getWeight() );
        }
        characterDTO.setHistory( character.getHistory() );
        characterDTO.setMovies( movieListToMovieDTOList( character.getMovies() ) );

        return characterDTO;
    }

    protected List<CharacterDTO> characterListToCharacterDTOList(List<Character> list) {
        if ( list == null ) {
            return null;
        }

        List<CharacterDTO> list1 = new ArrayList<CharacterDTO>( list.size() );
        for ( Character character : list ) {
            list1.add( characterToCharacterDTO( character ) );
        }

        return list1;
    }

    protected List<Movie> movieDTOListToMovieList(List<MovieDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Movie> list1 = new ArrayList<Movie>( list.size() );
        for ( MovieDTO movieDTO : list ) {
            list1.add( toMovie( movieDTO ) );
        }

        return list1;
    }

    protected Character characterDTOToCharacter(CharacterDTO characterDTO) {
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

    protected List<Character> characterDTOListToCharacterList(List<CharacterDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Character> list1 = new ArrayList<Character>( list.size() );
        for ( CharacterDTO characterDTO : list ) {
            list1.add( characterDTOToCharacter( characterDTO ) );
        }

        return list1;
    }
}
