package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserSerivceImplementation implements UserDetailsService {
    private final AppUserRepo appUserRepo;

    public UserSerivceImplementation(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser userByUsername = appUserRepo.findByUsername(username);

        return new AppUserDetails(userByUsername);
    }

    public void saveUser(AppUser user) {
        appUserRepo.save(user);
    }

    public AppUser findUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

    public String findUsernameById(Long id) {
        AppUser appUser = appUserRepo.findById(id).get();

        return appUser.getUsername();

    }

    public Optional<AppUser> findUserById(Long id) {
        return appUserRepo.findById(id);
    }

    }



