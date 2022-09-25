package alkemy.test.alkemy.test.dao;

import lombok.Data;

@Data
public class CharacterDAO {
    
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;
    //private MovieDAO movies;

    public CharacterDAO(String image, String name){
        this.image= image;
        this.name= name;
    }
}
