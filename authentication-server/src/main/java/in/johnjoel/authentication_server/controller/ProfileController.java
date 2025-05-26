package in.johnjoel.authentication_server.controller;

import in.johnjoel.authentication_server.io.ProfileRequest;
import in.johnjoel.authentication_server.io.ProfileResponse;
import in.johnjoel.authentication_server.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@Valid  @RequestBody ProfileRequest request) {
        ProfileResponse response = profileService.createProfile(request);

        //TODO: SEND WELCOME EMAIL
        return response;
    }

    @GetMapping("/profile")
    public ProfileResponse getProfile(@CurrentSecurityContext(expression = "authentication?.name") String email) {
        return profileService.getProfile(email);
    }
}

