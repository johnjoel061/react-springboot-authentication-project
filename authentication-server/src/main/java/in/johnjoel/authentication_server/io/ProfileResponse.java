package in.johnjoel.authentication_server.io;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProfileResponse {
    private String userId;
    private String name;
    private String email;
    private String isAccountVerified;
}
