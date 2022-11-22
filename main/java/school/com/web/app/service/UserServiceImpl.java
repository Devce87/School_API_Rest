package school.com.web.app.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import school.com.web.app.config.WebSecurityConfig;
import school.com.web.app.domain.entity.User;
import school.com.web.app.domain.repository.BaseRepositorioUser;
import school.com.web.app.service.interfaces.UserService;

import javax.jws.soap.SOAPBinding;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService<User> {

    private final BaseRepositorioUser baseRepositorioUser;

    @Override
    public boolean save(User entity) {

        String encodedPassword = new BCryptPasswordEncoder().encode(entity.getPassword());

        User user = User.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .password(encodedPassword)
                .build();

        baseRepositorioUser.save(user);
        return true;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }
}
