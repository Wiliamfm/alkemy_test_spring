package alkemy.test.alkemy.test.Mapper;

import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.entities.Genre;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-09T19:13:11-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Private Build)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDTO toGenreDTO(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        String name = null;
        String image = null;

        name = genre.getName();
        image = genre.getImage();

        GenreDTO genreDTO = new GenreDTO( name, image );

        return genreDTO;
    }

    @Override
    public Genre toGenre(GenreDTO genreDTO) {
        if ( genreDTO == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( genreDTO.getName() );
        genre.setImage( genreDTO.getImage() );

        return genre;
    }
}
