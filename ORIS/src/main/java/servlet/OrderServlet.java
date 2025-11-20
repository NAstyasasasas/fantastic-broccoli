package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

@WebServlet("/place-order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart?error=empty");
            return;
        }

        saveOrderToFile(cart);

        session.removeAttribute("cart");

        response.sendRedirect("success-order");
    }

    private void saveOrderToFile(Map<Integer, Integer> cart) {
        try {
            File file = new File("orders.txt");
            FileWriter writer = new FileWriter(file, true);

            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write("Заказ от " + timestamp + ": " + cart.toString() + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}