package myexception;

/**
 * @author LX
 * @date 2019/5/26 - 21:34
 */
public class LoginException extends Exception {

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
