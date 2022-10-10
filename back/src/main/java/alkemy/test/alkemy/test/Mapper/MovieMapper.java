package alkemy.test.alkemy.test.Mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface MovieMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "calification", target = "calification")
    //@Mapping(source = "characters", target = "characters")
    @Mapping(source = "genres", target = "genres")
    MovieDTO toMovieDTO(Movie movie);

    List<MovieDTO> toMoviesDTO(List<Movie> movies);

    @InheritInverseConfiguration
    @Mapping(target = "characters", ignore = true)
    Movie toMovie (MovieDTO movieDTO);
    
}
