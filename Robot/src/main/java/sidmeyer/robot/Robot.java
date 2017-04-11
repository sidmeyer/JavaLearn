package sidmeyer.robot;

public class Robot implements RobotConnection, RobotConnectionManager {

    @Override
    public RobotConnection getConnection() {
        return null;
    }

    @Override
    public void moveRobotTo(int x, int y) {
    }

    @Override
    public void close() {
    }
}
