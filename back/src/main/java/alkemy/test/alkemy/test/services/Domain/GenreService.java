package alkemy.test.alkemy.test.services.Domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.test.alkemy.test.Mapper.GenreMapper;
import alkemy.test.alkemy.test.dtos.GenreDTO;
import alkemy.test.alkemy.test.entities.Genre;
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

    public List<GenreDTO> getAll(){
        return genreMapper.toGenreDTOs((List<Genre>) genreRepository.findAll());
    }

    public GenreDTO getByName(String genre) {
        return genreMapper.toGenreDTO(genreRepository.findByName(genre));
    }
    
}
