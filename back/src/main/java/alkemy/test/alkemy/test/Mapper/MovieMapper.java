package alkemy.test.alkemy.test.Mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface MovieMapper {

    @Mapping(source = "image", target = "image")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "calification", target = "calification")
    //@Mapping(source = "characters", target = "characters")
    @Mapping(source = "genre", target = "genre")
    MovieDTO toMovieDTO(Movie movie);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    Movie toMovie (MovieDTO movieDAO);
    
}
