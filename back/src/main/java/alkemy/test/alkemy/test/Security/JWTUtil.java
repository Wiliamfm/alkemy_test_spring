package alkemy.test.alkemy.test.Security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import alkemy.test.alkemy.test.dtos.AuthDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateTocken(AuthDTO authDTO){
        return Jwts.builder().setSubject(authDTO.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 1)).signWith(key).compact();
    }
}
