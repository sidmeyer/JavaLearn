package sidmeyer.stepikweb.fin.accounts;

import org.eclipse.jetty.websocket.api.Session;
import sidmeyer.stepikweb.fin.dbService.DbService;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final DbService dbService;

    private final Map<Session, User> connectedUsers = new HashMap<>();

    public AccountService(DbService dbService) {
        this.dbService = dbService;
    }

    public void addUser(String userName, String password) {
        dbService.addUser(userName, password);
    }

    public User getUserByUserName(String userName) {
        User user = dbService.getByUserName(userName);
        return user;
    }

    public void addSession(Session session) {
        //TODO
    }
}
