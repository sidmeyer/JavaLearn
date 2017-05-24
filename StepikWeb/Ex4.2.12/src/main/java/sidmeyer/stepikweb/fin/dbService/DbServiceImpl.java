package sidmeyer.stepikweb.fin.dbService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;
import sidmeyer.stepikweb.fin.dbService.dao.UsersDao;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by stas on 19.05.17.
 */
public class DbServiceImpl implements DbService {
    private static final String hibernate_show_sql = "true";
//    private static final String hibernate_hbm2ddl_auto = "validate";

    private final SessionFactory sessionFactory;

    public DbServiceImpl() {
        Configuration configuration = getH2Configuration();
        sessionFactory = createSessionFactory(configuration);
    }

    public void addUser(final String userName, final String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UsersDao usersDao = new UsersDao(session);
        usersDao.addUser(userName, password);
        transaction.commit();
        session.close();
    }

    public User getById(final long userId) {
        Session session = sessionFactory.openSession();
        UsersDao usersDao = new UsersDao(session);
        User user = usersDao.getById(userId);
        //User usersDataSet0 = (User) session.load("id", userId);
        session.close();
        return user;
    }

    public User getByUserName(final String userName) {
        Session session = sessionFactory.openSession();
        UsersDao usersDao = new UsersDao(session);
        User user = usersDao.getByUserName(userName);
        //User usersDataSet0 = (User) session.load("id", userId);
        session.close();
        return user;
    }

    public void printConnectInfo() {
        try {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Configuration getH2Configuration() {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(User.class);

        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:h2:./h2db");
//        cfg.setProperty("hibernate.connection.username", "test");
//        cfg.setProperty("hibernate.connection.password", "test");
        cfg.setProperty("hibernate.show_sql", hibernate_show_sql);
//        cfg.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        cfg.setProperty("hibernate.enable_lazy_load_no_trans", "true");

        return cfg;
    }

    private SessionFactory createSessionFactory(final Configuration cfg) {
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
        ssrb.applySettings(cfg.getProperties());
        ServiceRegistry serviceRegistry = ssrb.build();
        return cfg.buildSessionFactory(serviceRegistry);
    }
}
