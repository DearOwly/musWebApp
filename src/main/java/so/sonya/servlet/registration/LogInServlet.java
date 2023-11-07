package so.sonya.servlet.registration;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.ftl").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.sendRedirect("authorization");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\15ARH05\\Desktop\\webapp\\muswebapp\\src\\main\\java\\so\\sonya\\data\\data.csv"))) {
            writer.write(username + ";" + password);
            writer.newLine();
        }

    }
}
