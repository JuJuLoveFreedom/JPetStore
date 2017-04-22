package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.AccountService;

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
public class NewOrderServlet extends HttpServlet {
    private AccountService service = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || username.equals("")){
            String url = request.getServletPath();
            System.out.println("url "+url);
            session.setAttribute("url",url);
            response.sendRedirect("/login");
        }
        Order order = (Order) session.getAttribute("order");
        order.setCardType(request.getParameter("order.cardType"));
        order.setCreditCard(request.getParameter("order.creditCard"));
        order.setExpiryDate(request.getParameter("order.expiryDate"));
        order.setBillToFirstName(request.getParameter("order.billToFirstName"));
        order.setBillToLastName(request.getParameter("order.billToLastName"));
        order.setBillAddress1(request.getParameter("order.billAddress1"));
        order.setBillAddress2(request.getParameter("order.billAddress2"));
        order.setBillCity(request.getParameter("order.billCity"));
        order.setBillState(request.getParameter("order.billState"));
        order.setBillZip(request.getParameter("order.billZip"));
        order.setBillCountry(request.getParameter("order.billCountry"));
        // 不知道如何处理这个单选框
        String shippingAddressRequired=request.getParameter("shippingAddressRequired");
        if (shippingAddressRequired==null || shippingAddressRequired.equals("")){
            order.setShipAddress1(order.getBillAddress1());
            order.setShipAddress2(order.getBillAddress2());
            order.setShipCity(order.getBillCity());
            order.setShipState(order.getBillState());
            order.setShipCountry(order.getBillCountry());
            order.setShipToFirstName(order.getBillToFirstName());
            order.setShipToLastName(order.getBillToLastName());
            order.setShipZip(order.getBillZip());
            session.setAttribute("order",order);
            request.getRequestDispatcher("/WEB-INF/jsp/order/ConfirmOrder.jsp").forward(request,response);
        }else {
            session.setAttribute("order",order);
            request.getRequestDispatcher("/WEB-INF/jsp/order/ShippingForm.jsp").forward(request,response);
        }
    }
}
