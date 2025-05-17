package in.johnjoel.authentication_server.repository;

import in.johnjoel.authentication_server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByVerifyOtp(String verifyOtp);

}
