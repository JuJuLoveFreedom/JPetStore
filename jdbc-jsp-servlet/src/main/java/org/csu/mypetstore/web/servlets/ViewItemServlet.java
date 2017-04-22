package org.csu.mypetstore.web.servlets;

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
public class ViewItemServlet extends HttpServlet {
    CatalogService service = new CatalogService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemId = request.getParameter("itemId");
        Item item = service.getItem(itemId);

        HttpSession session = request.getSession();
        session.setAttribute("item",item);
        request.getRequestDispatcher("/WEB-INF/jsp/catalog/Item.jsp").forward(request,response);
    }
}
