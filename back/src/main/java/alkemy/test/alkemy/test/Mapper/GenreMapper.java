package alkemy.test.alkemy.test.Mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.entities.Genre;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "image", target = "image")
    GenreDTO toGenreDTO (Genre genre);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movies", ignore = true)
    Genre toGenre (GenreDTO genreDTO);
    
}
