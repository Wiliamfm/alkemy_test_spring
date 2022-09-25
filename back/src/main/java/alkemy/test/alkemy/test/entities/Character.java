package alkemy.test.alkemy.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Character {

    @Id
    @GeneratedValue
    private Integer id;
    private String image;
    @Column(nullable = false)
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    
}
