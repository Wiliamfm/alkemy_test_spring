package alkemy.test.alkemy.test.Mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Character;
import alkemy.test.alkemy.test.entities.Genre;
import alkemy.test.alkemy.test.entities.Movie;
import alkemy.test.alkemy.test.services.CharacterService;
import alkemy.test.alkemy.test.services.Domain.GenreService;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Autowired
    private GenreService genreService;
    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private CharacterService characterService;

    public abstract MovieDTO toMovieDTO(Movie movie);

    protected List<Character> mapCharacters(List<String> characterNames){
        try {
            List<Character> characters= new ArrayList<>();
            characterNames.forEach(c -> {
                Character character = characterService.getByName(c);
                System.out.println(character);
                characters.add(character);
            });
            return characters;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    protected List<String> mapCharacterNames(List<Character> characters){
        try {
            List<String> characterNames= new ArrayList<>();
            characters.forEach(c -> {
                characterNames.add(c.getName());
            });
            return characterNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    protected List<Genre> mapGenres(List<String> genreNames){
        List<Genre> genres= new ArrayList<>();
        genreNames.forEach(genre -> {
            genres.add(genreMapper.toGenre(genreService.getByName(genre)));
        });
        return genres;
    }

    protected List<String> mapGenresId(List<Genre> genres){
        List<String> genreNames= new ArrayList<>();
        genres.forEach(genre -> {
            genreNames.add(genre.getName());
        });
        return genreNames;
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calification", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "genres", ignore = true)
    public abstract MovieDTO toMovieDTO(String image, String title, LocalDate creationDate);

    public abstract List<MovieDTO> toMoviesDTO(List<Movie> movies);

    @InheritInverseConfiguration
    public abstract Movie toMovie (MovieDTO movieDTO);
    
}
