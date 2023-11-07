package so.sonya.servlet.registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationSelvlet extends HttpServlet {
    private boolean checkProfile(String username, String password){
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\15ARH05\\Desktop\\webapp\\muswebapp\\src\\main\\java\\so\\sonya\\data\\data.csv"))){
            String info = reader.readLine();
            while(info != null){
                String[] data = info.split(";");
                if (data[0].equals(username) && data[1].equals(password)){
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("authorization.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (checkProfile(username, password)){
            request.getSession(true).setAttribute("User", username);
            response.sendRedirect("profile");
        } else {
            response.sendRedirect("login");
        }
    }
}
