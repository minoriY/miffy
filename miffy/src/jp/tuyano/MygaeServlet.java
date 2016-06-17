package jp.tuyano;

import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;
 
@SuppressWarnings("serial")
public class MygaeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<LinkData> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + LinkData.class.getName();
            try {
                List<LinkData> execute = (List<LinkData>)manager.newQuery(query).execute();
				list = execute;
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                LinkData data = (LinkData)manager.getObjectById(LinkData.class,Long.parseLong(param1));
                list = new ArrayList<LinkData>();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(LinkData data:list){
                res += "{id:" + data.getId() + ",date:'" + data.getDate() + "',title:'" +
                    data.getTitle() + "',datetime:'" + data.getDatetime() +
                    "',place:'" + data.getPlace() +
                    "',comment:'" + data.getComment() +
                    "',member:'" + data.getMember() +  "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}