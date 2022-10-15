package alkemy.test.alkemy.test.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDTO{
    
    private int id;
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;
    private List<MovieDTO> movies;

    public CharacterDTO(String image, String name){
        this.image= image;
        this.name= name;
    }
}
