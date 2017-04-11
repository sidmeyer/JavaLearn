package sidmeyer.robot;

/**
 * Created by stas on 11.04.17.
 */
public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
