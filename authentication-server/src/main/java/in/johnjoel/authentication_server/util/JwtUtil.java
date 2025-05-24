package in.johnjoel.authentication_server.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> cliams = new HashMap<>();
        return createToken(cliams, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> cliams, String username) {
        Jwts.builder()
                .setClaims(cliams)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10hr expiration
                . signWith(SignatureAlgorithm.HS256, SECRET_KEY)

    }

}
