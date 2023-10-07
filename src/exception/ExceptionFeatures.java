package exception;

import javax.security.auth.login.LoginException;

public class ExceptionFeatures {

    public final static String PATTERN = "[\\w]{5,20}";

    public static void main (String[] args){
        try {
            auth("Login@","Pass", "Pass");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPassException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean auth(String username, String password, String confirmPass) throws WrongLoginException, WrongPassException {
    if (!username.matches(PATTERN)){
        throw new WrongLoginException("Invalid username");
    }
    if (!password.matches(PATTERN)){
        throw new WrongPassException("Invalid password");
    }
    if (!confirmPass.matches(PATTERN)){
        throw new WrongPassException("Invalid confirmation password");
    }
    return true;
    }
}
