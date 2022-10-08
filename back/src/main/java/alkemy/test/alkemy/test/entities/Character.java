package alkemy.test.alkemy.test.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String image;
    @Column(nullable = false)
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "characters_movies",
        joinColumns = @JoinColumn(name = "character"),
        inverseJoinColumns = @JoinColumn(name = "movie")
    )
    private List<Movie> movies;
    
}
