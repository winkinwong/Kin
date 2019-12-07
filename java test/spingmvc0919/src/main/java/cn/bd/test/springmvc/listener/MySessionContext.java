package cn.bd.test.springmvc.listener;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @program: spingmvc0919
 * @description: 自定义SessionContext
 * @author: 黄永健
 * @create: 2019-09-20 14:29
 **/
public class MySessionContext {

    private static HashMap mymap = new HashMap();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
            return null;
        return (HttpSession) mymap.get(session_id);
    }
}