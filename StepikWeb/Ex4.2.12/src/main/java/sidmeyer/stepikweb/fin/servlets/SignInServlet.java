package sidmeyer.stepikweb.fin.servlets;

import sidmeyer.stepikweb.fin.accounts.AccountService;
import sidmeyer.stepikweb.fin.dbService.datasets.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by stas on 21.05.17.
 */
public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = accountService.getUserByUserName(request.getParameter("login"));
            if(null != user && user.getPassword().equals(request.getParameter("password"))) {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Authorized: " + request.getParameter("login"));
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Unauthorized");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
