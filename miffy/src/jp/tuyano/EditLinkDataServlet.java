package jp.tuyano;
 
import java.io.IOException;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class EditLinkDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        String place = req.getParameter("place");
        String detail = req.getParameter("detail");
        String member = req.getParameter("member");
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        LinkData data = (LinkData)manager.getObjectById(LinkData.class,id);
        data.setTitle(title);
        data.setDate(date);
        data.setPlace(place);
        data.setDetail(detail);
        data.setMember(member);
        manager.close();
        resp.sendRedirect("/welcome.html");
    }
}