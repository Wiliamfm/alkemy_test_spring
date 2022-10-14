package alkemy.test.alkemy.test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.test.alkemy.test.entities.Genre;
import alkemy.test.alkemy.test.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{

    public List<Movie> findAllByTitleContainingIgnoreCase(String title);
    public List<Movie> findAllByGenre(Genre genre);
    public List<Movie> orderByCreationDateAsc();
    public List<Movie> orderByCreationDateDesc();
    
}
