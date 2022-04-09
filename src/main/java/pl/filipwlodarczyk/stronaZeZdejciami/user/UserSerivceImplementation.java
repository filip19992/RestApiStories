package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService;
import pl.filipwlodarczyk.stronaZeZdejciami.user.registration.AppUserRegistrationForm;
import pl.filipwlodarczyk.stronaZeZdejciami.user.registration.PasswordValidator;

import java.util.Optional;


@Service
public class UserSerivceImplementation implements UserDetailsService {

    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;
    public UserSerivceImplementation(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
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

    public void saveAppUser(AppUserRegistrationForm form) throws Exception {

        if(PasswordValidator.validatePassword(form.getPassword())) {
            appUserRepo.save(new AppUser(form.getUsername(),passwordEncoder.encode(form.getPassword()),form.getAge(),"ROLE_USER"));
        }
    }


    }



