package sidmeyer.stepikweb.fin.dbService;

import sidmeyer.stepikweb.fin.dbService.datasets.User;

/**
 * Created by Stas on 21.05.2017.
 */
public interface DbService {

	void addUser(String userName, String password);

	User getByUserName(String userName);

	void addMessage(User user, String message);
}
