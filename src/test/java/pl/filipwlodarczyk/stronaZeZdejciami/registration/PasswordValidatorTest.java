package pl.filipwlodarczyk.stronaZeZdejciami.registration;

import org.junit.Test;
import pl.filipwlodarczyk.stronaZeZdejciami.registration.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;


public class PasswordValidatorTest {
    @Test
    public void shouldValidateWhenPasswordWithFirstUppercaseGiven() throws Exception {

        PasswordValidator.validatePasswordResponse validatePasswordResponse = PasswordValidator.validatePassword("Password*");

        boolean validated = validatePasswordResponse.isValidated();

        assertTrue(validated);
    }

    @Test
    public void shouldNotValidateWhenPasswordWithFirstLowerCaseGiven() {

        PasswordValidator.validatePasswordResponse validatePasswordResponse = PasswordValidator.validatePassword("password");

        boolean validated = validatePasswordResponse.isValidated();

        assertFalse(validated);
    }

    @Test
    public void shouldNotValidateWhenPasswordTooLongIsGiven() {
        //more than 20 letters given
        PasswordValidator.validatePasswordResponse validatePasswordResponse = PasswordValidator.validatePassword("passasdasdasdasdasdasdword");

        boolean validated = validatePasswordResponse.isValidated();

        assertFalse(validated);
    }

    @Test
    public void shouldNotValidateWhenPasswordTooShortIsGiven() {
        //less than 7 letters given
        PasswordValidator.validatePasswordResponse validatePasswordResponse = PasswordValidator.validatePassword("sdword");

        boolean validated = validatePasswordResponse.isValidated();

        assertFalse(validated);
    }


}
