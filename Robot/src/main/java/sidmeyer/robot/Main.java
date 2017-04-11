package sidmeyer.robot;

public class Main {
    public static void main(String[] args) {
        moveRobot(new RobotConnectionManager() {
            @Override
            public RobotConnection getConnection() {
                return new RobotConnection() {
                    @Override
                    public void moveRobotTo(int x, int y) {
                        throw new RuntimeException("RuntimeException in moveRobotTo()");
                        //throw new RobotConnectionException("RobotConnectionException in moveRobotTo()");
                    }

                    @Override
                    public void close() {

                    }
                };
            }
        }, 5, 3);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int i;
        for (i = 0; i < 3; i++) {
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                i = 10;
            } catch (RobotConnectionException rce) {
            } catch (Exception e) {
                throw e;
            }
        }
        if (i < 10)
            throw new RobotConnectionException("Error");
    }
}
