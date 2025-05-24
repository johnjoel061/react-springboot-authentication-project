package in.johnjoel.authentication_server.service;

import in.johnjoel.authentication_server.entity.UserEntity;
import in.johnjoel.authentication_server.io.ProfileRequest;
import in.johnjoel.authentication_server.io.ProfileResponse;
import in.johnjoel.authentication_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = convertToUserEntity(request);

        if (!userRepository.existsByEmail(request.getEmail())) {
            newProfile = userRepository.save(newProfile);
            return convertToProfileResponse(newProfile);
        }

        throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
    }

    private ProfileResponse convertToProfileResponse(UserEntity userEntity) {
        return ProfileResponse.builder()
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .userId(userEntity.getUserId())
                .isAccountVerified(userEntity.getIsAccountVerified())
                .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isAccountVerified(String.valueOf(false))
                .resetOtpExpiresAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();
    }
}
