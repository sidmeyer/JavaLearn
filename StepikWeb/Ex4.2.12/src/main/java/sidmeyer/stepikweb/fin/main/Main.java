package sidmeyer.stepikweb.fin.main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sidmeyer.stepikweb.fin.accounts.AccountService;
import sidmeyer.stepikweb.fin.dbService.DbService;
import sidmeyer.stepikweb.fin.dbService.DbServiceImpl;
import sidmeyer.stepikweb.fin.servlets.SignInServlet;
import sidmeyer.stepikweb.fin.servlets.SignUpServlet;

/**
 * Created by stas on 19.05.17.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        DbService dbService = new DbServiceImpl();
        AccountService accountService = new AccountService(dbService);
        Server server = getServer(accountService);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();


    }

    private static Server getServer(AccountService accountService) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        return server;
    }
}
