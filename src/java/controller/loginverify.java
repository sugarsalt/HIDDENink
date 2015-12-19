/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import listens.SessionListener;
import model.Users;

/**
 *
 * @author hi
 */
public class loginverify extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = "home.jsp";
        String msg = "";
        try {
            /* TODO output your page here. You may use following sample code. */
            String Email = request.getParameter("Email").trim();
            String password = request.getParameter("password").trim();
            String Fname = "";

            Users obj = new Users();
            obj.setEmail(Email);
            obj.setPassword(password);

            HttpSession session = request.getSession();
            int sessionCounter = SessionListener.totalsessioncount;
            System.out.println(sessionCounter + "****");
            if (sessionCounter > 1) {
                if (SessionListener.PervoiusName.equals(Email)) {
                    if (obj.UpdateStatus()) {
                        SessionListener.totalsessioncount = 0;
                        path = "blocked.jsp";
                    } else {
                        SessionListener.totalsessioncount = 0;
                    }
                } else {
                    SessionListener.totalsessioncount = 0;
                }

            }
            if (obj.CheckStatus()) {
                if (obj.loginVerify()) {
                    msg = "Login Successful";
                    Fname = obj.getFname();
                    System.out.println(Fname);
                    session.setAttribute("First_Name", Fname);
                    session.setAttribute("Email", Email);
                    session.setAttribute("usertype", "user");
                } else {
                    SessionListener.totalsessioncount++;
                    msg = "Login Unsuccessful";
                    System.out.println(SessionListener.totalsessioncount + "////");
                    System.out.println(Email);
                    System.out.println(password);
                }
            } else {
                path = "blocked.jsp";
                msg = "Login Unsuccessful 2";
            }
            SessionListener.PervoiusName = Email;
            System.out.println(SessionListener.PervoiusName + "////");
            session.setAttribute("msg", msg);
            response.sendRedirect(path + "?msg=" + msg);
        } catch (Exception e) {
            System.out.println(e);
            path = "errorPage.jsp";
            msg = e.getMessage();
            request.setAttribute("msg", msg);
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
