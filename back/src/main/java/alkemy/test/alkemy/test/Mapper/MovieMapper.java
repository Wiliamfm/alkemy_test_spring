package alkemy.test.alkemy.test.Mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "image", target = "image")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "calification", target = "calification")
    //@Mapping(source = "characters", target = "characters")
    MovieDTO toMovieDTO(Movie movie);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Movie toMovie (MovieDTO movieDAO);
    
}
