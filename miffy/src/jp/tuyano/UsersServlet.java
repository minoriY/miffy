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
      resp.getWriter().println("<center><p><br>こんにちは！ "
          + req.getUserPrincipal().getName()
          + "さん!<br><a href=\""
          + userService.createLogoutURL("/welcome.html")
          + "\">(・×・)miffy(・×・) TOPへ</a></p><img src='/img/rabbit4.png'>");
    } else {
      resp.getWriter().println("<center><p><br><a href=\""
            + userService.createLoginURL(thisUrl)
            + "\">ろぐいんろぐいん！</a></p><img src='/img/rabbit5.png'></center>");
    }
  }
}