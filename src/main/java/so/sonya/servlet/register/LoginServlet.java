package so.sonya.servlet.register;

import so.sonya.dto.LogInForm;
import so.sonya.dto.UserEntityDto;
import so.sonya.service.AuthorizationService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    AuthorizationService authorizationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        authorizationService = (AuthorizationService) config.getServletContext().getAttribute("authorizationService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            LogInForm form = LogInForm.builder()
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            UserEntityDto user = authorizationService.signIn(form);
            req.getSession().setAttribute("user", user);
        } catch (RuntimeException e){
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("login.ftl").forward(req, resp);
        }
        resp.sendRedirect("profile");
    }
}
