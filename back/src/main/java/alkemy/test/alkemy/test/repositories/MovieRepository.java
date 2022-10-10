package alkemy.test.alkemy.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.test.alkemy.test.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
    
}
