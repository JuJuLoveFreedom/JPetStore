package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
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
 * Created by pikachu on 2017/3/11.
 */
public class RegisterServlet extends HttpServlet {
    private AccountService accountService = new AccountService();
    private CatalogService catalogService = new CatalogService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = new Account();
        account.setUsername(request.getParameter("username"));
        account.setPassword(request.getParameter("password"));
        account.setFirstName(request.getParameter("account.firstName"));
        account.setLastName(request.getParameter("account.lastName"));
        account.setEmail(request.getParameter("account.email"));
        account.setPhone(request.getParameter("account.phone"));
        account.setAddress1(request.getParameter("account.address1"));
        account.setAddress2(request.getParameter("account.address2"));
        account.setCity(request.getParameter("account.city"));
        account.setState(request.getParameter("account.state"));
        account.setStatus(request.getParameter(""));
        account.setZip(request.getParameter("account.zip"));
        account.setCountry(request.getParameter("account.country"));
        account.setLanguagePreference(request.getParameter("account.languagePreference"));
        account.setFavouriteCategoryId(request.getParameter("account.favouriteCategoryId"));
        String a  = request.getParameter("account.listOption");
        String b  = request.getParameter("account.bannerOption");
        accountService.insertAccount(account);
        session.setAttribute("username",account.getUsername());
        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> categories = catalogService.getAllCategoriesId();
        List<String> languages = new LinkedList<>();
        languages.add("Chinese");
        languages.add("English");
        languages.add("Japanese");
        session.setAttribute("categories",categories);
        session.setAttribute("languages",languages);
        request.getRequestDispatcher("/WEB-INF/jsp/account/NewAccountForm.jsp").forward(request,response);
    }
}
