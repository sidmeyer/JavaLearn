package sidmeyer.stepikweb.db.accounts;

import sidmeyer.stepikweb.db.dbService.DbService;
import sidmeyer.stepikweb.db.dbService.datasets.UsersDataSet;

/**
 * Created by stas on 21.05.17.
 */
public class AccountService {
    DbService dbService = new DbService();

    public void addUser(String userName, String password) {
        dbService.addUser(userName, password);
    }

    public UsersDataSet getUserByUserName(String userName) {
        UsersDataSet usersDataSet = dbService.getByUserName(userName);
        return usersDataSet;
    }
}
