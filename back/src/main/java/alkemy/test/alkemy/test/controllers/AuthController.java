package alkemy.test.alkemy.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alkemy.test.alkemy.test.Security.JWTUtil;
import alkemy.test.alkemy.test.dtos.AuthDTO;
import alkemy.test.alkemy.test.dtos.ErrorDTO;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;
    
    @PostMapping("/login")
    private ResponseEntity<? extends Object> createTocken(@RequestBody AuthDTO authDTO){
        try {
            return ResponseEntity.ok(jwtUtil.generateTocken(authDTO));
        } catch(BadCredentialsException badCredentialsException){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(badCredentialsException.getMessage()), HttpStatus.FORBIDDEN);
        } catch(Exception e){
            return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
