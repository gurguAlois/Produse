package servlet;

import operations.DbUsers;
import users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginUser extends HttpServlet {


    private String name;
    private String password;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = new PrintWriter(response.getWriter());
        out.println("<html><head><title> Hello World Title </title></head>");
        out.println("<body>Hello There" + new Date());
        out.println("</body></html>");

        out.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        this.name = name;
        this.password = password;

        request.setAttribute("name", name);
        request.setAttribute("password", password);

        DbUsers dbUsers = new DbUsers();
        try {
            User user = dbUsers.getUserByName(name, password);
            String message = "Welcome to my page " + name;
            request.setAttribute("message", message);
            request.getRequestDispatcher("/succes.jsp").forward(request, response);
        }
        catch(Exception e) {
            String message = "User cannot be find";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }


        request.getRequestDispatcher("/error.jsp").forward(request, response);

    }

}



