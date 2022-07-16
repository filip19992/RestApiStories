package pl.filipwlodarczyk.stronaZeZdejciami.registration;


public class PasswordValidator {
    public static validatePasswordResponse validatePassword(String password)  {

        Character firstChar = password.charAt(0);

       if (password.length() < 7) {
           return new validatePasswordResponse(false, "Password is too short");
       } else if (password.length() > 20) {
           return new validatePasswordResponse(false,"password is too long");
       } else if (firstChar < 64 || firstChar > 90) {
           return new validatePasswordResponse(false,"First lettter is not an upper case");
       } else {
           return new validatePasswordResponse(true, "Password valided");
       }
    }


    public static class validatePasswordResponse{
        boolean isValidated;
        String message;

        public validatePasswordResponse(boolean isValidated, String message) {
            this.isValidated = isValidated;
            this.message = message;
        }

        public boolean isValidated() {
            return isValidated;
        }

        public String getMessage() {
            return message;
        }
    }


}
