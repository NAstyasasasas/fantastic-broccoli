<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, servlet.Product" %>
<%
    Map<Integer, Integer> cart = (Map<Integer, Integer>) request.getAttribute("cart");
    List<Product> products = (List<Product>) request.getAttribute("products");

    double total = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Корзина</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
    <div class="menu">
        <a href="index.html">Главная</a>
        <a href="about.html">О котятах</a>
        <a href="gallery.html">Фоточки</a>
        <a href="contact.html">Контакты</a>
        <a href="products">Купить котика</a>
        <a href="cart" style="color: red;">Корзина</a>
    </div>

    <div style="text-align: center; margin-top: 20px;">
        <h1>Ваша корзина</h1>

        <% if (cart.isEmpty()) { %>
            <p>Корзина пуста</p>
            <a href="products">Выбрать котика</a>
        <% } else { %>
            <div class="cart-items">
                <% for (Product product : products) {
                    if (cart.containsKey(product.getId())) {
                        int quantity = cart.get(product.getId());
                        double subtotal = product.getPrice() * quantity;
                        total += subtotal;
                %>
                    <div class="cart-item">
                        <img src="<%= product.getImage() %>" width="100">
                        <h3><%= product.getName() %></h3>
                        <p>Цена: <%= product.getPrice() %> руб.</p>
                        <p>Количество: <%= quantity %></p>
                        <p>Сумма: <%= subtotal %> руб.</p>
                    </div>
                <% } } %>

                <div class="cart-total">
                    <h2>Итого: <%= total %> руб.</h2>
                    <form action="place-order" method="post">
                        <button type="submit">Оформить заказ</button>
                    </form>
                </div>
            </div>
        <% } %>
    </div>
</body>
</html>