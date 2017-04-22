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
public class AddItemToCartServlet extends HttpServlet {

    private String itemId;
    private Cart cart;

    private CatalogService catalogService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        itemId = request.getParameter("itemId");

        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");

        if (cart == null){
            cart = new Cart();
        }

        if (cart.containsItemId(itemId)){
            cart.incrementQuantityByItemId(itemId);
        }else {
            catalogService = new CatalogService();
            boolean isInStock = catalogService.isItemInStock(itemId);
            Item item = catalogService.getItem(itemId);
            cart.addItem(item,isInStock);
        }
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/WEB-INF/jsp/cart/Cart.jsp").forward(request,response);
    }
}
