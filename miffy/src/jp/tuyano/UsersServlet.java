package jp.tuyano;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    UserService userService = UserServiceFactory.getUserService();

    String thisUrl = req.getRequestURI();

    resp.setContentType("text/html; charset=utf-8");
    if (req.getUserPrincipal() != null) {
      resp.getWriter().println("<p>こんにちは！ "
          + req.getUserPrincipal().getName()
          + "さん! <a href=\""
          + userService.createLogoutURL("/welcome.html")
          + "\">お部屋へ行く</a></p>");
    } else {
      resp.getWriter().println("<p><a href=\""
            + userService.createLoginURL(thisUrl)
            + "\">ろぐいんろぐいん！</a></p>");
    }
  }
}