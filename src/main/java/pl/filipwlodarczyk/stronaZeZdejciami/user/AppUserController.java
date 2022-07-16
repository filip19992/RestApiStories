package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.filipwlodarczyk.stronaZeZdejciami.registration.AppUserForm;
import pl.filipwlodarczyk.stronaZeZdejciami.story.Story;
import pl.filipwlodarczyk.stronaZeZdejciami.story.StoryService;

import java.util.List;
import java.util.Optional;

@Controller
public class AppUserController {
    private final UserSerivceImplementation userService;
    private final StoryService storyService;

    public AppUserController(UserSerivceImplementation userService, StoryService storyService) {
        this.userService = userService;
        this.storyService = storyService;
    }

    @RequestMapping(value = "/profile/{id}")
    public String getProfileById(Model model, @PathVariable Long id) throws Exception {

        Optional<AppUser> userById = userService.findUserById(id);
        Optional<List<Story>> storiesByAuthorId = storyService.findStoryByAuthorId(id);

        model.addAttribute("username",userById.get().getUsername());
        model.addAttribute("stories",storiesByAuthorId);

        return "profile";
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }
}
