package sidmeyer.stepikweb.db.main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sidmeyer.stepikweb.db.accounts.AccountService;
//import sidmeyer.stepikweb.db.dbService.DbService;
//import sidmeyer.stepikweb.db.dbService.datasets.UsersDataSet;
import sidmeyer.stepikweb.db.servlets.SignInServlet;
import sidmeyer.stepikweb.db.servlets.SignUpServlet;

/**
 * Created by stas on 19.05.17.
 */
public class Main {
    private static final AccountService ACCOUNT_SERVICE = new AccountService();

    private static Server server = getServer();

    public static void main(String[] args) throws Exception {

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();



//        DbService dbService = new DbService();
//        dbService.printConnectInfo();
//
//        dbService.addUser("Petro", "passPetro");
//        dbService.addUser("Stepan", "passStepan");
//        UsersDataSet user1 = dbService.getById(1L);
//        System.out.println("user1: " + user1.getUserName() + ":" + user1.getPassword());
//
//        UsersDataSet user2 = dbService.getById(2L);
//        System.out.println("user2: " + user2.getUserName() + ":" + user2.getPassword());
    }

    private static Server getServer() {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignInServlet(ACCOUNT_SERVICE)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(ACCOUNT_SERVICE)), "/signup");


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        return server;
    }
}
