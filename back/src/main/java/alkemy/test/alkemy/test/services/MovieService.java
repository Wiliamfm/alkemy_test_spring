package alkemy.test.alkemy.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alkemy.test.alkemy.test.Mapper.MovieMapper;
import alkemy.test.alkemy.test.dtos.MovieDTO;
import alkemy.test.alkemy.test.entities.Movie;
import alkemy.test.alkemy.test.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieMapper movieMapper;

    public List<MovieDTO> getAll(){
        List<Movie> movies= (List<Movie>) movieRepository.findAll();
        return movieMapper.toMoviesDTO(movies);
    }

    public MovieDTO getById(int id){
        return movieMapper.toMovieDTO(movieRepository.findById(id).map(movie -> {
            return movie;
        }).orElseGet(null));
    }

    @Transactional
    public MovieDTO create(MovieDTO movieDTO) throws IllegalArgumentException{
        return movieMapper.toMovieDTO(movieRepository.save(movieMapper.toMovie(movieDTO)));
    }

    @Transactional
    public MovieDTO update(int id, MovieDTO movieDTO) throws IllegalArgumentException{
        Movie movie= movieMapper.toMovie(getById(id));
        movie.setId(id);
        movie.setImage(movieDTO.getImage());
        movie.setTitle(movieDTO.getTitle());
        movie.setCreationDate(movieDTO.getCreationDate());
        movie.setCalification(movieDTO.getCalification());
        //movie.setGenres();
        return movieMapper.toMovieDTO(movieRepository.save(movie));
    }

    @Transactional
    public MovieDTO delete(int id) throws IllegalArgumentException{
        MovieDTO movie= getById(id);
        movieRepository.deleteById(id);
        return movie;
    }
    
}
