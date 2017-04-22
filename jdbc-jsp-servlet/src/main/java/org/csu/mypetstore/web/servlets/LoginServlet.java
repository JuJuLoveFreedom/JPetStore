package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pikachu on 2017/3/11.
 */
public class LoginServlet extends HttpServlet {
    private AccountService service = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = service.getAccount(username,password);
        if (account == null){
            session.setAttribute("error","Username or Password Error");
            response.sendRedirect("/login");
        }else {
            session.setAttribute("username",username);
            String url = (String) session.getAttribute("url");
            if (url==null || url.equals("")){
                response.sendRedirect("/main");
            }else {
                session.setAttribute("url",null);
                response.sendRedirect(url);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/account/SignonForm.jsp").forward(request,response);
    }

}
