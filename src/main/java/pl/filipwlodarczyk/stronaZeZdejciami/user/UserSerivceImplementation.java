package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService;
import pl.filipwlodarczyk.stronaZeZdejciami.user.registration.AppUserRegistrationForm;
import pl.filipwlodarczyk.stronaZeZdejciami.user.registration.PasswordValidator;

import java.util.Optional;


@Service
public class UserSerivceImplementation implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    public UserSerivceImplementation(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Bean
    private BCryptPasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser userByUsername = appUserRepo.findByUsername(username);

        return new AppUserDetails(userByUsername);
    }

    public void saveUser(AppUser user) {
        appUserRepo.save(user);
    }

    public AppUser findUserByUsername(String username) throws Exception {
        if(username != null) {
            return appUserRepo.findByUsername(username);
        } else {
            throw new Exception("There is no user with this username");
        }
    }

    public String findUsernameById(Long id) {
        AppUser appUser = appUserRepo.findById(id).get();

        return appUser.getUsername();

    }

    public Optional<AppUser> findUserById(Long id) {
        return appUserRepo.findById(id);
    }


    //TODO: Data doesnt send after submit in html

    public void registerAppUser(AppUserRegistrationForm form) throws Exception {
        if(PasswordValidator.validatePassword(form.getPassword())) {
            appUserRepo.save(new AppUser(form.getUsername(),
                    passwordEncoder().encode(form.getPassword()),
                    form.getAge(),
                    "ROLE_USER"));
        }
    }
}



