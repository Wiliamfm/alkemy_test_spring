package alkemy.test.alkemy.test.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class ErrorDTO extends AbstractResponse{

    private String message;
    
}
