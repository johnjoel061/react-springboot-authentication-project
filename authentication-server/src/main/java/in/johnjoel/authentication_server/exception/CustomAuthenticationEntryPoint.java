package in.johnjoel.authentication_server.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
        response.setContentType("application/json");

        // Reconstruct full URL: scheme + server name + port + URI + query string (if any)
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        String fullURL = (queryString == null) ? requestURL.toString() : requestURL.append('?').append(queryString).toString();

        String jsonResponse = String.format(
                "{ \"error\": \"401 Unauthorized\", \"message\": \"%s\", \"path\": \"%s\" }",
                authException.getMessage(),
                fullURL
        );

        response.getWriter().write(jsonResponse);

        System.out.println("🔒 Unauthorized access:");
        System.out.println(" - Full URL: " + fullURL);
        System.out.println(" - Reason: " + authException.getMessage());
    }

}
