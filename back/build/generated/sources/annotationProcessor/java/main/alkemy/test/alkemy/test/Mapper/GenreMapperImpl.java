package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.entities.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T21:10:01-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDTO toGenreDTO(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        String image = null;

        if ( genre.getId() != null ) {
            id = genre.getId();
        }
        name = genre.getName();
        image = genre.getImage();

        GenreDTO genreDTO = new GenreDTO( id, name, image );

        return genreDTO;
    }

    @Override
    public Genre toGenre(GenreDTO genreDTO) {
        if ( genreDTO == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setId( genreDTO.getId() );
        genre.setName( genreDTO.getName() );
        genre.setImage( genreDTO.getImage() );

        return genre;
    }

    @Override
    public List<GenreDTO> toGenreDTOs(List<Genre> genres) {
        if ( genres == null ) {
            return null;
        }

        List<GenreDTO> list = new ArrayList<GenreDTO>( genres.size() );
        for ( Genre genre : genres ) {
            list.add( toGenreDTO( genre ) );
        }

        return list;
    }
}
