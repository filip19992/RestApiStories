package pl.filipwlodarczyk.stronaZeZdejciami;

public class RoleFoundException extends RuntimeException{
    public RoleFoundException(String roleName) {
        super(roleName + "is active in database");
    }
}
