package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by pikachu on 2017/3/11.
 */
public class UpdateCartQuantitiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }

        Iterator<CartItem> iterator = cart.getAllCartItems();
        while (iterator.hasNext()){
            CartItem item = iterator.next();
            int n = Integer.parseInt(request.getParameter(item.getItem().getItemId()));
            item.setQuantity(n);
        }
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/WEB-INF/jsp/cart/Cart.jsp").forward(request,response);
    }
}
