package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T21:10:15-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class MovieMapperImpl extends MovieMapper {

    @Override
    public MovieDTO toMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        if ( movie.getId() != null ) {
            movieDTO.setId( movie.getId() );
        }
        movieDTO.setImage( movie.getImage() );
        movieDTO.setTitle( movie.getTitle() );
        movieDTO.setCreationDate( movie.getCreationDate() );
        if ( movie.getCalification() != null ) {
            movieDTO.setCalification( movie.getCalification() );
        }
        movieDTO.setCharacters( mapCharacterNames( movie.getCharacters() ) );
        movieDTO.setGenres( mapGenresId( movie.getGenres() ) );

        return movieDTO;
    }

    @Override
    public MovieDTO toMovieDTO(String image, String title, LocalDate creationDate) {
        if ( image == null && title == null && creationDate == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setImage( image );
        movieDTO.setTitle( title );
        movieDTO.setCreationDate( creationDate );

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

        Movie movie = new Movie();

        movie.setId( movieDTO.getId() );
        movie.setImage( movieDTO.getImage() );
        movie.setTitle( movieDTO.getTitle() );
        movie.setCreationDate( movieDTO.getCreationDate() );
        movie.setCalification( movieDTO.getCalification() );
        movie.setCharacters( mapCharacters( movieDTO.getCharacters() ) );
        movie.setGenres( mapGenres( movieDTO.getGenres() ) );

        return movie;
    }
}
