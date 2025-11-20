package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Рыжий котик", 5000, "https://i.pinimg.com/736x/b9/ef/c6/b9efc6fad9d2ff6d491c4c11c6e7a08c.jpg"));
        products.add(new Product(2, "Серый котик", 4500, "https://i.pinimg.com/1200x/04/4a/67/044a6747b726027c1f8dcd8871a2d4ea.jpg"));
        products.add(new Product(3, "Белый котик", 6000, "https://i.pinimg.com/736x/35/ed/51/35ed51676a9f0ec54676152fd1659694.jpg"));
        products.add(new Product(4, "Черный котик", 4000, "https://i.pinimg.com/736x/96/05/57/9605572441a9e0ff0017a9bc68102ae9.jpg"));

        request.setAttribute("cart", cart);
        request.setAttribute("products", products);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}