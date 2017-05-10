package sidmeyer.stepikweb.authorization.main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sidmeyer.stepikweb.authorization.accounts.AccountService;
import sidmeyer.stepikweb.authorization.servlets.SignInServlet;
import sidmeyer.stepikweb.authorization.servlets.SignUpServlet;

/**
 * Ex. 2.3.16
 * https://stepik.org/lesson/%D0%A3%D0%B3%D0%BB%D1%83%D0%B1%D0%BB%D0%B5%D0%BD%D0%BD%D1%8B%D0%B5-%D0%BE%D1%81%D0%BD%D0%BE%D0%B2%D1%8B-%D1%8F%D0%B7%D1%8B%D0%BA%D0%B0-12497/step/15?course=%D0%A0%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%BA%D0%B0-%D0%B2%D0%B5%D0%B1-%D1%81%D0%B5%D1%80%D0%B2%D0%B8%D1%81%D0%B0-%D0%BD%D0%B0-Java-(%D1%87%D0%B0%D1%81%D1%82%D1%8C-1)&unit=2967
 */
public class Main {
    public static void main(String[] args) throws Exception{
        AccountService accountService = new AccountService();


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();


    }
}
