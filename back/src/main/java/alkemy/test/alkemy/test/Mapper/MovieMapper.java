package alkemy.test.alkemy.test.Mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface MovieMapper {

    MovieDTO toMovieDTO(Movie movie);

    List<MovieDTO> toMoviesDTO(List<Movie> movies);

    @InheritInverseConfiguration
    Movie toMovie (MovieDTO movieDTO);
    
}
