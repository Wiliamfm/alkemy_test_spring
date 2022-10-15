package alkemy.test.alkemy.test.entities;

import java.time.LocalDate;
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

@Entity
@Data
public class Movie {

    public Movie(String image2, String title2, LocalDate creationDate2) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String image;
    private String title;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Column()
    private Integer calification;
    @ManyToMany(mappedBy = "movies")
    private List<Character> characters;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "movie_genre",
        joinColumns = @JoinColumn(name = "movie"),
        inverseJoinColumns = @JoinColumn(name = "genre")
    )
    private List<Genre> genres;

}
