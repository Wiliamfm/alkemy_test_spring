package alkemy.test.alkemy.test.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class MovieDTO{

    private int id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int calification;
    private List<CharacterDTO> characters;
    private List<GenreDTO> genres;

}
