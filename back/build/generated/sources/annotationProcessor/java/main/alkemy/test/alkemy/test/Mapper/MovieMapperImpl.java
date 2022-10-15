package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.CharacterDTO;
import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Character;
import alkemy.test.alkemy.test.entities.Genre;
import alkemy.test.alkemy.test.entities.Movie;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T18:35:09-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class MovieMapperImpl implements MovieMapper {

    @Autowired
    private GenreMapper genreMapper;

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        int id = 0;
        String image = null;
        String title = null;
        LocalDate creationDate = null;
        int calification = 0;
        List<CharacterDTO> characters = null;
        List<GenreDTO> genres = null;

        if ( movie.getId() != null ) {
            id = movie.getId();
        }
        image = movie.getImage();
        title = movie.getTitle();
        creationDate = movie.getCreationDate();
        if ( movie.getCalification() != null ) {
            calification = movie.getCalification();
        }
        characters = characterListToCharacterDTOList( movie.getCharacters() );
        genres = genreMapper.toGenreDTOs( movie.getGenres() );

        MovieDTO movieDTO = new MovieDTO( id, image, title, creationDate, calification, characters, genres );

        return movieDTO;
    }

    @Override
    public MovieDTO toMovieDTO(String image, String title, LocalDate creationDate) {
        if ( image == null && title == null && creationDate == null ) {
            return null;
        }

        String image1 = null;
        image1 = image;
        String title1 = null;
        title1 = title;
        LocalDate creationDate1 = null;
        creationDate1 = creationDate;

        int id = 0;
        int calification = 0;
        List<CharacterDTO> characters = null;
        List<GenreDTO> genres = null;

        MovieDTO movieDTO = new MovieDTO( id, image1, title1, creationDate1, calification, characters, genres );

        return movieDTO;
    }

    @Override
    public List<MovieDTO> toMoviesDTO(List<Movie> movies) {
        if ( movies == null ) {
            return null;
        }

        List<MovieDTO> list = new ArrayList<MovieDTO>( movies.size() );
        for ( Movie movie : movies ) {
            list.add( toMovieDTO( movie ) );
        }

        return list;
    }

    @Override
    public Movie toMovie(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        String image2 = null;
        String title2 = null;
        LocalDate creationDate2 = null;

        Movie movie = new Movie( image2, title2, creationDate2 );

        movie.setId( movieDTO.getId() );
        movie.setImage( movieDTO.getImage() );
        movie.setTitle( movieDTO.getTitle() );
        movie.setCreationDate( movieDTO.getCreationDate() );
        movie.setCalification( movieDTO.getCalification() );
        movie.setCharacters( characterDTOListToCharacterList( movieDTO.getCharacters() ) );
        movie.setGenres( genreDTOListToGenreList( movieDTO.getGenres() ) );

        return movie;
    }

    protected CharacterDTO characterToCharacterDTO(Character character) {
        if ( character == null ) {
            return null;
        }

        int id = 0;
        String image = null;
        String name = null;
        int age = 0;
        double weight = 0.0d;
        String history = null;
        List<MovieDTO> movies = null;

        if ( character.getId() != null ) {
            id = character.getId();
        }
        image = character.getImage();
        name = character.getName();
        if ( character.getAge() != null ) {
            age = character.getAge();
        }
        if ( character.getWeight() != null ) {
            weight = character.getWeight();
        }
        history = character.getHistory();
        movies = toMoviesDTO( character.getMovies() );

        CharacterDTO characterDTO = new CharacterDTO( id, image, name, age, weight, history, movies );

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

        character.setId( characterDTO.getId() );
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

    protected List<Genre> genreDTOListToGenreList(List<GenreDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Genre> list1 = new ArrayList<Genre>( list.size() );
        for ( GenreDTO genreDTO : list ) {
            list1.add( genreMapper.toGenre( genreDTO ) );
        }

        return list1;
    }
}
