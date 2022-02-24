package pl.filipwlodarczyk.stronaZeZdejciami.home;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.filipwlodarczyk.stronaZeZdejciami.story.Story;
import pl.filipwlodarczyk.stronaZeZdejciami.story.StoryService;
import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUser;
import pl.filipwlodarczyk.stronaZeZdejciami.user.UserSerivceImplementation;

import java.util.List;
import java.util.Optional;

@Controller
public class TemplateController {

    private final StoryService storyService;
    private final UserSerivceImplementation userService;

    public TemplateController(StoryService storyService, UserSerivceImplementation userService) {
        this.storyService = storyService;
        this.userService = userService;
    }

    @RequestMapping(value = "/home")
    public String getHelloPage(Model model) {
        List<Story> allStories = storyService.findAllStories();
        model.addAttribute("stories", allStories);
        return "home";
    }

    @RequestMapping(value = "/profile/{id}")
    public String getProfileById(Model model, @PathVariable Long id) {

        Optional<AppUser> userById = userService.findUserById(id);
        List<Story> storiesByAuthorId = storyService.findStoryByAuthorId(id);

        model.addAttribute("username",userById.get().getUsername());
        model.addAttribute("stories",storiesByAuthorId);

        return "profile";
    }
}
