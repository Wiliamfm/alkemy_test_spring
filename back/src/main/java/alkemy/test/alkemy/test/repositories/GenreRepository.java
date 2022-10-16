package alkemy.test.alkemy.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.test.alkemy.test.entities.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer>{

    Genre findByName(String name);
    
}
