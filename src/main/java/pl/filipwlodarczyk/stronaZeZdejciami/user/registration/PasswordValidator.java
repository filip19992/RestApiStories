package pl.filipwlodarczyk.stronaZeZdejciami.user.registration;


public class PasswordValidator {
    public static boolean validatePassword(String password) throws Exception {

        Character firstChar = password.charAt(0);

       if (password.length() < 7) {
           throw new Exception("password is too short");
       } else if (password.length() > 20) {
           throw new Exception("password is too long");
       } else if (firstChar.charValue() < 64 || firstChar.charValue() > 90) {
           throw new Exception("First lettter is not an upper case");
       } else {
           return true;
       }
    }
}
