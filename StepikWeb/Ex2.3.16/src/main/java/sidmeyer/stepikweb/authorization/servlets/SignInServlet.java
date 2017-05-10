package sidmeyer.stepikweb.authorization.servlets;

import sidmeyer.stepikweb.authorization.accounts.AccountService;
import sidmeyer.stepikweb.authorization.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * При получении POST запроса на signin, после регистрации, SignInServlet проверяет,
 * логин/пароль пользователя. Если пользователь уже зарегистрирован, север отвечает
 */
public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet(final AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserProfile userProfile = new UserProfile(req.getParameter("login"), req.getParameter("password"));
        if (accountService.userExist(userProfile)) {
            //System.out.println("user exists!");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("Authorized: " + req.getParameter("login"));
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            //System.out.println("no such user!");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
