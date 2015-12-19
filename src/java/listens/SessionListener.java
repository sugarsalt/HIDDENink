/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listens;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author hi
 */
public class SessionListener implements HttpSessionListener{

    public static int totalsessioncount;
    public static String PervoiusName;
    

    public static int getTotalsessioncount() {
        return totalsessioncount;
    }
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        totalsessioncount++;
        System.out.println("Session created = "+totalsessioncount);
      }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed = "+totalsessioncount);
    }
    
}
