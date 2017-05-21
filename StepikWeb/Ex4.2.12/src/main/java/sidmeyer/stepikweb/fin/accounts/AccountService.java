package sidmeyer.stepikweb.fin.accounts;

import sidmeyer.stepikweb.fin.dbService.DbService;
import sidmeyer.stepikweb.fin.dbService.datasets.UsersDataSet;

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

    public UsersDataSet getUserByUserName(String userName) {
        UsersDataSet usersDataSet = dbService.getByUserName(userName);
        return usersDataSet;
    }
}
