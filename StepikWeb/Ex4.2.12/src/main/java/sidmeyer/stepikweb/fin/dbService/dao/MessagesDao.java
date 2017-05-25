package sidmeyer.stepikweb.fin.dbService.dao;

import org.hibernate.Session;
import sidmeyer.stepikweb.fin.dbService.datasets.ChatMessage;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

/**
 * Created by stas on 25.05.17.
 */
public class MessagesDao {
    private Session session;

    public MessagesDao(Session session) {
        this.session = session;
    }

    public long addMessage(final User user, final String message) {
        return (long) session.save(new ChatMessage(user, message));
    }
}
