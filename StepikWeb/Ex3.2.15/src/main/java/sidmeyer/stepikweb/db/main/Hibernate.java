package sidmeyer.stepikweb.db.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import sidmeyer.stepikweb.db.dao.UserDataSet;
import sidmeyer.stepikweb.db.dao.UsersDao;

import java.util.List;

/**
 * Created by stas on 15.05.17.
 */
public class Hibernate {
//    public static void main(String[] args) {
//        Configuration cfg = new Configuration();
//        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/webserver");
//        cfg.setProperty("hibernate.connection.username", "root");
//        cfg.setProperty("hibernate.connection.password", "root");
//        cfg.setProperty("hibernate.show_sql", "true");
//        cfg.setProperty("hibernate.hbm2dll.auto", "validate");
//
//        cfg.addAnnotatedClass(UserDataSet.class);
//
//        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
//        ssrb.applySettings(cfg.getProperties());
//        ServiceRegistry serviceRegistry = ssrb.build();
//        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//
////        Session session = sessionFactory.openSession();
////        Transaction transaction = session.beginTransaction();
////
////        System.out.append(transaction.getLocalStatus().toString());
////
////        session.close();
//
//
//        UsersDao usersDao = new UsersDao(sessionFactory);
//
//        UserDataSet user1 = usersDao.getById(1);
//        //printUserDataSet(user1);
//
//        UserDataSet newUser = new UserDataSet("Tim", "Ericsson", "te@example.com", false, "2017-05-18");
//        //usersDao.save(newUser);
//        //UserDataSet user2 = usersDao.getByEmail("te@example.com");
//        //printUserDataSet(user2);
//
//        //usersDao.delete(new UserDataSet("Tim", "Ericsson", "te@example.com", false, "2017-05-18"));
//
//        List<UserDataSet> mayUsers = usersDao.getByRegisterDateRange("2017-05-01", "2017-05-31");
//        mayUsers.forEach(Hibernate::printUserDataSet);
//
//        sessionFactory.close();
//    }
//
//    private static void printUserDataSet(UserDataSet userDataSet) {
//        System.out.printf("id: %d\nfirstName: %s\nlastname: %s\nemail: %s\nconfirmed: %s\nsignUpDate: %s\n",
//                userDataSet.getId(), userDataSet.getFirstName(), userDataSet.getLastName(), userDataSet.getEmail(), userDataSet.isConfirmed(), userDataSet.getSignUpDate());
//
//    }
//

}
