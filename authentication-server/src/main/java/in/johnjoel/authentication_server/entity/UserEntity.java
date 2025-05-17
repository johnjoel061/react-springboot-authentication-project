package in.johnjoel.authentication_server.entity;

public class UserEntity {
    private Long id;
    private String name;
    private String email;
    private String password;
    private  String verifyOtp;
    private String isAccountVerified;
    private String resetOtp;
    private Long resetOtpExpiresAt;
}
