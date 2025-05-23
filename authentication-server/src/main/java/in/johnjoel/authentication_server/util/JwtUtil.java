package in.johnjoel.authentication_server.util;

import lombok.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

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
        SECRET_KEY
    }

}
