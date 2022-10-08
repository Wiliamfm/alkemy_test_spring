package alkemy.test.alkemy.test.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MovieDTO extends AbstractResponse{

    private String image;
    private String title;
    private LocalDate creationDate;
    private int calification;
    //private List<CharacterDTO> characters;
    private GenreDTO genre;

}
