package in.johnjoel.authentication_server.io;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProfileRequest {

    @NotBlank(message = "Name should not be empty")
    private String name;
    @Email(message = "Enter valid email address")
    @NotNull(message = "Email should be not empty")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}

