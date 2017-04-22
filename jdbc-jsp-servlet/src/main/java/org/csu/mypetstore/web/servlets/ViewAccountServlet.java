package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.impl.AccountDAOImpl;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/23.
 */
public class ViewAccountServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAOImpl();
    private CatalogService catalogService = new CatalogService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Account account = accountDAO.getAccountByUsername(username);
        List<String> categories = catalogService.getAllCategoriesId();
        List<String> languages = new LinkedList<>();
        languages.add("Chinese");
        languages.add("English");
        languages.add("Japanese");
        session.setAttribute("languages",languages);
        session.setAttribute("account",account);
        session.setAttribute("categories",categories);
        request.getRequestDispatcher("/WEB-INF/jsp/account/EditAccountForm.jsp").forward(request,response);
    }
}
