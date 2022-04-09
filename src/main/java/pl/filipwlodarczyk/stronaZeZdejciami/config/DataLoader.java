package pl.filipwlodarczyk.stronaZeZdejciami.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.filipwlodarczyk.stronaZeZdejciami.role.Role;
import pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService;
import pl.filipwlodarczyk.stronaZeZdejciami.story.Story;
import pl.filipwlodarczyk.stronaZeZdejciami.story.StoryService;
import pl.filipwlodarczyk.stronaZeZdejciami.user.AppUser;
import pl.filipwlodarczyk.stronaZeZdejciami.user.UserSerivceImplementation;

import java.util.Random;

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
        roleService.saveRole(new Role("ROLE_ADMIN"));
        appUserService.saveUser(new AppUser(
                "filip19992", passwordEncoder().encode("password"), 22,"ROLE_ADMIN"));

        appUserService.saveUser(new AppUser("user","password", 25, "ROLE_USER"));

        storyService.saveStory(new Story("Opowiesc", "Tu bedzie tresc", appUserService.findUserByUsername("filip19992")));
        storyService.saveStory(new Story("Opowiesc2", "asdasdasdasd", appUserService.findUserByUsername("filip19992")));
        storyService.saveStory(new Story("Opowiesc3", generateString(), appUserService.findUserByUsername("filip19992")));
        storyService.saveStory(new Story("Opowiesc4", generateString(), appUserService.findUserByUsername("user")));
        storyService.saveStory(new Story("Opowiesc5", generateString(), appUserService.findUserByUsername("user")));
        storyService.saveStory(new Story("Opowiesc6", generateString(), appUserService.findUserByUsername("user")));

    }


    private String generateString() {
        char[] chars = new char[300];


        for (int i = 0; i < chars.length; i++) {
            char  j =
            chars[i] = generateChar();
        }

        return String.valueOf(chars);
    }

    private char generateChar() {
        char[] chars = {'s', 'a', 'b', 'c', 'f', 'g', 'h'};
        Random random = new Random();

        int i = random.nextInt(0, chars.length);

        return chars[i];

    }

}
