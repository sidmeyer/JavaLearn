package sidmeyer.stepikweb.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Created by stas on 17.05.17.
 */
public class UsersDao {

    private final SessionFactory sessionFactory;

    public UsersDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(UserDataSet userDataSet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userDataSet);
        transaction.commit();
        session.close();
    }

    public UserDataSet getById(long id) {
        Session session = sessionFactory.openSession();
        return (UserDataSet) session.load(UserDataSet.class, id);
    }

    public UserDataSet getByEmail(String email) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (UserDataSet) criteria
                .add(Restrictions.eq("email", email))
                .uniqueResult();
                //.list().get(0);
    }

    public void delete(UserDataSet userDataSet) {
        Session session = sessionFactory.openSession();
        session.delete(userDataSet);
        //return (UserDataSet) session.delete(id);
    }
}
