package sidmeyer.stepikweb.fin.dbService.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import sidmeyer.stepikweb.fin.dbService.datasets.UsersDataSet;

/**
 * Created by stas on 19.05.17.
 */
public class UsersDao {
    private Session session;

    public UsersDao(Session session) {
        this.session = session;
    }

    public long addUser(final String userName, final String password) {
        return (long) session.save(new UsersDataSet(userName, password));
    }

    public UsersDataSet getById(final long userId) {
        return (UsersDataSet) session.load(UsersDataSet.class, userId);
    }

    public UsersDataSet getByUserName(final String userName) {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (UsersDataSet) criteria.uniqueResult();
    }
}
