package school.com.web.app.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import school.com.web.app.domain.entity.User;
import school.com.web.app.domain.repository.BaseRepositorioUser;
import school.com.web.app.exception.ExceptionMessage;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final BaseRepositorioUser baseRepositorioUser;

    public UserDetailServiceImpl(BaseRepositorioUser baseRepositorioUser) {
        this.baseRepositorioUser = baseRepositorioUser;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = baseRepositorioUser
                .findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con email "+email+" no existe."));

        return new UserDetailsImpl(user);
    }


}
