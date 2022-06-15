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

        storyService.saveStory(new Story("Opowiesc", "“The Yellow Wallpaper” by Charlotte Perkins Gilman explores a woman’s descent into madness after she’s confined to a room with yellow wallpaper to help her nervous disorder. It is a groundbreaking short story that drew attention to mental health and women’s rights when it was released and has influenced many writers, including Alice Walker and Sylvia Plath.", appUserService.findUserByUsername("filip19992")));
        storyService.saveStory(new Story("Opowiesc2", "Reading some of these short stories can better acquaint you with the short story form and the challenges faced by authors to develop an interesting plot and detailed characters. Investigate a few additional popular examples of short stories.", appUserService.findUserByUsername("filip19992")));
        storyService.saveStory(new Story("Opowiesc3", "Explore an individual's fall into the abyss of insanity in Edgar Allan Poe’s “The Fall of the House of Usher.” Poe’s poetic prose creates an air of suspense as he weaves the twisted tale of the House of Usher.", appUserService.findUserByUsername("filip19992")));
        storyService.saveStory(new Story("Opowiesc4", "In \"The Lottery” by Shirley Jackson, tradition and community ties lead to deadly consequences when a woman is chosen in the eponymous lottery to be stoned to death.", appUserService.findUserByUsername("user")));
        storyService.saveStory(new Story("Opowiesc5", "“The Gift of the Magi” by O. Henry is a classic story with a powerful theme of love and giving. In just a few short pages, O. Henry creates sympathetic characters that the audience can relate to. This glimpse into their lives highlights both their power of character and the key themes of the story such as love, giving and sacrifice.", appUserService.findUserByUsername("user")));
        storyService.saveStory(new Story("Opowiesc6", "In \"The Lottery” by Shirley Jackson, tradition and community ties lead to deadly consequences when a woman is chosen in the eponymous lottery to be stoned to death.", appUserService.findUserByUsername("user")));

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
