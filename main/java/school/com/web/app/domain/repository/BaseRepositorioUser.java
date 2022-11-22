package school.com.web.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.com.web.app.domain.entity.User;

import java.util.Optional;

public interface BaseRepositorioUser extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);


}
