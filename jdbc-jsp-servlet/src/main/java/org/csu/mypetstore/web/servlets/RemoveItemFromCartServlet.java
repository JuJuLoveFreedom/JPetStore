package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pikachu on 2017/3/11.
 */
public class RemoveItemFromCartServlet extends HttpServlet {
    private String itemId;
    private Cart cart;

    private CatalogService catalogService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        itemId = request.getParameter("itemId");

        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        Item item = cart.removeItemById(itemId);
        session.setAttribute("cart",cart);
        if (item == null) {
            session.setAttribute("message", "Attempted to remove null");

            request.getRequestDispatcher("/WEB-INF/jsp/common/Error.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/cart/Cart.jsp").forward(request, response);

        }
    }
}
