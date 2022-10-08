package alkemy.test.alkemy.test.dtos;

import java.util.List;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class GenreDTO extends AbstractResponse{

    @Column(unique = true)
    private String name;
    private String image;
    
}
