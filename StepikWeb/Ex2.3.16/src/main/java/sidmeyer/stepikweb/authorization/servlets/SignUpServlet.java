package sidmeyer.stepikweb.authorization.servlets;

import sidmeyer.stepikweb.authorization.accounts.AccountService;
import sidmeyer.stepikweb.authorization.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * При получении POST запроса на signup сервлет SignUpServlet должн запомнить логин и пароль в AccountService.
 * После этого польователь с таким логином считается зарегистрированным.
 */
public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        accountService.addNewUser(new UserProfile(req.getParameter("login"), req.getParameter("password")));
    }
}
