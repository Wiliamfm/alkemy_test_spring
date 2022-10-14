package alkemy.test.alkemy.test.Mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.entities.Genre;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDTO toGenreDTO (Genre genre);

    @InheritInverseConfiguration
    @Mapping(target = "movies", ignore = true)
    Genre toGenre (GenreDTO genreDTO);

    List<GenreDTO> toGenreDTOs(List<Genre> genres);
    
}
