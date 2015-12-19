
package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hi
 */
public class AdminFilter implements Filter {
FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig=filterConfig;
        System.out.println("Filter intialised");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) res;
        HttpSession session=request.getSession();
        String userType=(String)session.getAttribute("usertype");
        if(userType!=null && userType.equals("admin")){
            System.out.println(userType);
            chain.doFilter(req, res);
        }
        else{
            response.sendRedirect("../home.jsp");
        }
        
        
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroyed");
    }
    
}

