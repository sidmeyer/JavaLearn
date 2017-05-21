package sidmeyer.stepikweb.db.servlets;

import sidmeyer.stepikweb.db.accounts.AccountService;

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
            if(accountService.getUserByUserName(userName) == null) {
                accountService.addUser(userName, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
