package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.filipwlodarczyk.stronaZeZdejciami.user.registration.AppUserRegistrationForm;

@Controller
public class AppUserController {
    private final UserSerivceImplementation userService;

    public AppUserController(UserSerivceImplementation userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String registerAppUser(@ModelAttribute("form") AppUserRegistrationForm form, Model model) throws Exception {
        model.addAttribute("form", form);
        userService.registerAppUser(form);
        return "registration";
    }

    @RequestMapping(value = "/registration")
    public String getRegistrationPage(Model model, AppUserRegistrationForm form) {
        model.addAttribute("form", form);
        return "registration";
    }
}
