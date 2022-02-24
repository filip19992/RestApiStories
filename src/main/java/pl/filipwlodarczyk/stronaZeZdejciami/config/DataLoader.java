package pl.filipwlodarczyk.stronaZeZdejciami.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.filipwlodarczyk.stronaZeZdejciami.role.Role;
import pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService;
import pl.filipwlodarczyk.stronaZeZdejciami.story.StoryModel;
import pl.filipwlodarczyk.stronaZeZdejciami.story.StoryService;
import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUser;
import pl.filipwlodarczyk.stronaZeZdejciami.user.UserSerivceImplementation;

@Component
public class DataLoader implements ApplicationRunner {



    @Bean
    private BCryptPasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    private final UserSerivceImplementation appUserService;
    private final RoleService roleService;
    private final StoryService storyService;

    public DataLoader(UserSerivceImplementation appUserService, RoleService roleService, StoryService storyService) {
        this.appUserService = appUserService;
        this.roleService = roleService;
        this.storyService = storyService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleService.saveRole(new Role("ROLE_USER"));
        appUserService.saveUser(new AppUser(
                "filip19992", passwordEncoder().encode("password"), 22,"ROLE_USER"));

        storyService.saveStory(new StoryModel("Opowiesc", "Tu bedzie tresc", appUserService.findUserByUsername("filip19992")));

        storyService.saveStory(new StoryModel("Opowiesc2", "asdasdasdasd", appUserService.findUserByUsername("filip19992")));

    }
}
