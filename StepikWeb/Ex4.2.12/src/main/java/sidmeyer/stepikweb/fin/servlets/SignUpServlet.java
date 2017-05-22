package sidmeyer.stepikweb.fin.servlets;

import sidmeyer.stepikweb.fin.accounts.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by stas on 21.05.17.
 */
public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String userName = request.getParameter("login");
            String password = request.getParameter("password");
            if(null == accountService.getUserByUserName(userName)) {
                accountService.addUser(userName, password);
                response.getWriter().write("New user registered: " + userName);
            } else {
                response.getWriter().write("User '" + userName + "' already registered");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
