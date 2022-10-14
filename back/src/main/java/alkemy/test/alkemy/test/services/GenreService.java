package alkemy.test.alkemy.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.test.alkemy.test.Mapper.GenreMapper;
import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.repositories.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreMapper genreMapper;

    public GenreDTO getById(int id){
        return genreMapper.toGenreDTO(genreRepository.findById(id).map(genre -> {
            return genre;
        }).orElse(null));
    }
    
}
