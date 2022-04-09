package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.filipwlodarczyk.stronaZeZdejciami.user.registration.AppUserRegistrationForm;

@RestController
public class AppUserController {
    private final UserSerivceImplementation userService;

    public AppUserController(UserSerivceImplementation userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerAppUser(@RequestBody AppUserRegistrationForm form) {
        userService.saveAppUser(form);
    }
}
