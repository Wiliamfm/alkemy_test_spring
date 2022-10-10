package alkemy.test.alkemy.test.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import alkemy.test.alkemy.test.entities.Character;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Integer>{

    List<Character> findByNameContainingIgnoreCase(String name);
    List<Character> findByAge(int age);
    List<Character> findByMovies(int movieId);
    
}
