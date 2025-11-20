<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, servlet.Product" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Котики для покупки</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
    <div class="menu">
        <a href="index.html">Главная</a>
        <a href="about.html">О котятах</a>
        <a href="gallery.html">Фоточки</a>
        <a href="contact.html">Контакты</a>
        <a href="products" style="color: red;">Купить котика</a>
        <a href="cart">Корзина</a>
    </div>

    <div style="text-align: center; margin-top: 20px;">
        <h1>Котики ждут своего дома!</h1>
        <p>Выбери себе пушистого друга</p>
    </div>

    <div class="products-container">
        <% for (Product product : products) { %>
            <div class="product-card">
                <img src="<%= product.getImage() %>" width="200">
                <h3><%= product.getName() %></h3>
                <p>Цена: <%= product.getPrice() %> руб.</p>
                <form action="add-to-cart" method="post">
                    <input type="hidden" name="productId" value="<%= product.getId() %>">
                    <button type="submit">В корзину</button>
                </form>
            </div>
        <% } %>
    </div>
</body>
</html>