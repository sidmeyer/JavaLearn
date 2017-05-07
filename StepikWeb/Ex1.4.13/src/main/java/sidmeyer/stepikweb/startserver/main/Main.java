package sidmeyer.stepikweb.startserver.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sidmeyer.stepikweb.startserver.servlets.Mirror;

import javax.servlet.Servlet;

public class Main {
    public static void main(String[] args) throws Exception {
        Servlet mirror = new Mirror();

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        server.setHandler(context);

        context.addServlet(new ServletHolder(mirror), "/mirror");

        server.start();
        //System.out.println("Server started");
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
