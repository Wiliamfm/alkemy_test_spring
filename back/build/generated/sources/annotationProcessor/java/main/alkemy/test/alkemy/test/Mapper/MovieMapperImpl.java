package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Genre;
import alkemy.test.alkemy.test.entities.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-09T19:13:11-0500",
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
        movieDTO.setGenres( genreListToGenreDTOList( movie.getGenres() ) );

        return movieDTO;
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
        movie.setGenres( genreDTOListToGenreList( movieDTO.getGenres() ) );

        return movie;
    }

    protected List<GenreDTO> genreListToGenreDTOList(List<Genre> list) {
        if ( list == null ) {
            return null;
        }

        List<GenreDTO> list1 = new ArrayList<GenreDTO>( list.size() );
        for ( Genre genre : list ) {
            list1.add( genreMapper.toGenreDTO( genre ) );
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
