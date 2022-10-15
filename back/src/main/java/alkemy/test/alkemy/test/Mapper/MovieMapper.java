package alkemy.test.alkemy.test.Mapper;

import java.time.LocalDate;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface MovieMapper {

    MovieDTO toMovieDTO(Movie movie);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calification", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "genres", ignore = true)
    MovieDTO toMovieDTO(String image, String title, LocalDate creationDate);

    List<MovieDTO> toMoviesDTO(List<Movie> movies);

    @InheritInverseConfiguration
    Movie toMovie (MovieDTO movieDTO);
    
}
