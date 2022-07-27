package pl.filipwlodarczyk.stronaZeZdejciami.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.filipwlodarczyk.stronaZeZdejciami.role.Role;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepoTest {

    @Autowired
    private AppUserRepo underTest;

    @Test
    void findByUsername() {
    }

    @Test
    void itShouldReturnTrueIfExistsByUsername() {
        //given
        String username = "Filip";
        AppUser appUser = new AppUser(
                "Filip",
                "Password",
                20,
                "ROLE_USER");

        underTest.save(appUser);

        //when
        Boolean result = underTest.existsByUsername(username);

        //then
        assertEquals(true, result);
    }

    @Test
    void itShouldReturnFalseIfExistsByUsername() {
        //given
        String username = "Filip";

        //when
        Boolean result = underTest.existsByUsername(username);

        //then
        assertEquals(false, result);
    }
}