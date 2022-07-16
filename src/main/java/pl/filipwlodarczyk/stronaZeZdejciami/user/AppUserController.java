package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.filipwlodarczyk.stronaZeZdejciami.registration.AppUserForm;

@Controller
public class AppUserController {
    private final UserSerivceImplementation userService;

    public AppUserController(UserSerivceImplementation userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String registerAppUser(@ModelAttribute("appUserForm") AppUserForm appUserForm, Model model) throws Exception {
        model.addAttribute("appUserForm", appUserForm);
        userService.registerAppUser(appUserForm);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model,@ModelAttribute("appUserForm") AppUserForm appUserForm) {
        model.addAttribute("appUserForm", appUserForm);
        return "registration";
    }
}
