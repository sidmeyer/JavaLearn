package sidmeyer.stepikweb.fin.dbService.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

/**
 * Created by stas on 19.05.17.
 */
public class UsersDao {
    private Session session;

    public UsersDao(Session session) {
        this.session = session;
    }

    public long addUser(final String userName, final String password) {
        return (long) session.save(new User(userName, password));
    }

    public User getById(final long userId) {
        return (User) session.load(User.class, userId);
    }

    public User getByUserName(final String userName) {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (User) criteria.uniqueResult();
    }
}
