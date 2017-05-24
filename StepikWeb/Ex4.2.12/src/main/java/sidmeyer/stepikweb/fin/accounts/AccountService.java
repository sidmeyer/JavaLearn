package sidmeyer.stepikweb.fin.accounts;

import sidmeyer.stepikweb.fin.dbService.DbService;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

/**
 * Created by stas on 21.05.17.
 */
public class AccountService {
    private final DbService dbService;

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
}
