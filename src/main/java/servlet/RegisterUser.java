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

@WebServlet(name = "HelloServlet", urlPatterns = "/register")
public class RegisterUser extends HttpServlet {

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
        System.out.println(password);
        this.name = name;
        this.password = password;
        createUser();

        request.setAttribute("name", name);
        request.setAttribute("password", password);

        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

    public void createUser(){
        User user =  new User();
        user.setName(name);
        user.setPassword(password);
        DbUsers dbUsers = new DbUsers();
        dbUsers.insertUser(user);
    }
}
