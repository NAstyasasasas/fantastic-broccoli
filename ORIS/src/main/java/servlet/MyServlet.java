package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;


@WebServlet("/form")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Форма регистрации</h2>");

        String error = request.getParameter("error");
        if (error != null) {
            out.println("<p style='color:red'>" + error + "</p>");
        }

        out.println("<form method='post'>");
        out.println("Логин: <input type='text' name='login'><br><br>");
        out.println("Email: <input type='text' name='email'><br><br>");
        out.println("Пароль: <input type='password' name='password'><br><br>");
        out.println("<input type='submit' value='Отправить'>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String error = "";

        if (login == null || login.isEmpty()) {
            error = "Введите логин";
        } else if (email == null || email.isEmpty()) {
            error = "Введите email";
        } else if (!email.contains("@")) {
            error = "Email должен содержать @";
        } else if (password == null || password.isEmpty()) {
            error = "Введите пароль";
        }

        if (!error.isEmpty()) {
            response.sendRedirect("/form?error=" + error);
            return;
        }

        saveData(login, email, password);
        response.sendRedirect("/success");
    }

    private void saveData(String login, String email, String password) {
        try {
            File file = new File("data.txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write("Логин: " + login + ", Email: " + email + ", Дата: " + new Date() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}