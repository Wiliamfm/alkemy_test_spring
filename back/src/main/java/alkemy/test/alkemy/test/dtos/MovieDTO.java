package alkemy.test.alkemy.test.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO{

    private int id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int calification;
    private List<String> characters;
    private List<String> genres;

    protected MovieDTO(String image, String title, LocalDate creationDate){
        this.image= image;
        this.title= title;
        this.creationDate= creationDate;
    }

}
