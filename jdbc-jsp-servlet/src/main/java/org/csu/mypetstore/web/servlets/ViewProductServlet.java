package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by pikachu on 2017/3/10.
 */
public class ViewProductServlet extends HttpServlet {
    CatalogService service = new CatalogService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        Product product = service.getProduct(productId);
        List<Item> list = service.getItemListByProduct(productId);
        HttpSession session = request.getSession();
        session.setAttribute("product",product);
        session.setAttribute("itemList",list);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/Product.jsp").forward(request,response);
    }
}
