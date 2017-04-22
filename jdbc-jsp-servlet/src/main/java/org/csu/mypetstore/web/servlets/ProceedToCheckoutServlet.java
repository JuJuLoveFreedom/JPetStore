package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class ProceedToCheckoutServlet extends HttpServlet {
    private AccountService service = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username==null || username.equals("")){
            String url = request.getServletPath();
            System.out.println("url "+url);
            session.setAttribute("url",url);
            response.sendRedirect("/login");
        }else {
            List<String> list = new ArrayList<>();
            list.add("Visa");
            list.add("MasterCard");
            list.add("American Express");
            Account account = service.getAccount(username);
            Order order = new Order();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart==null){
                response.sendRedirect("/main");
            }
            order.initOrder(account,cart);
            session.setAttribute("account",account);
            session.setAttribute("creditCardTypes",list);
            session.setAttribute("order",order);
            request.getRequestDispatcher("/WEB-INF/jsp/order/NewOrderForm.jsp").forward(request,response);
        }

    }
}
