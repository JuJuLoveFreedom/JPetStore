package org.csu.mypetstore.web.servlets;

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
 * Created by pikachu on 2017/3/11.
 */
public class SearchProductServlet extends HttpServlet {
    CatalogService service = new CatalogService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String keyword = request.getParameter("keyword");
        List<Product> list = service.searchProductList(keyword);
        session.setAttribute("productList",list);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/SearchProducts.jsp").forward(request,response);
    }
}
