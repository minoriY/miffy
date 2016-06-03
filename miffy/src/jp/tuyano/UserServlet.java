
package jp.tuyano;

import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
 
        //ユーザーサービスの取得
        UserService us = UserServiceFactory.getUserService();
        com.google.appengine.api.users.User user = us.getCurrentUser();
 
        if(user == null){
            resp.getWriter().println("ログインしていません");
        }else{
            resp.getWriter().println("ログイン状態です");
            resp.getWriter().println("認証ドメイン:" + user.getAuthDomain());
            resp.getWriter().println("ニックネーム:" + user.getNickname());
            resp.getWriter().println("ユーザID    :" + user.getUserId());
            resp.getWriter().println("Eメール     :" + user.getEmail());
        }
    }
}
