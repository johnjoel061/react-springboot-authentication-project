package in.johnjoel.authentication_server.service;

import in.johnjoel.authentication_server.io.ProfileRequest;
import in.johnjoel.authentication_server.io.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);

    ProfileService getProfile(String email);
}
