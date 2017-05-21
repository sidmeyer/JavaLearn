package sidmeyer.stepikweb.fin.dbService;

import sidmeyer.stepikweb.fin.dbService.datasets.UsersDataSet;

/**
 * Created by Stas on 21.05.2017.
 */
public interface DbService {
	void addUser(String userName, String password);

	UsersDataSet getByUserName(String userName);
}
