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
import model.Users;

/**
 *
 * @author hi
 */
public class SignupServlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        String path = "home.jsp";
        String msg = "";
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String Fname = request.getParameter("Fname").trim();
            String Lname = request.getParameter("Lname").trim();
            String Email = request.getParameter("Email").trim();
            String password = request.getParameter("password").trim();
            String Cpassword = request.getParameter("Confirmpassword").trim();


            Users obj = new Users();
            obj.setFname(Fname);
            obj.setLname(Lname);
            obj.setEmail(Email);
            obj.setPassword(password);
            obj.setConfirmPassword(Cpassword);
            if (obj.getPassword().equals(obj.getConfirmPassword())) {
                if (obj.SignupConfirm()) {
                    msg = "Sign Up Successful";
                    path = "home.jsp";

                    session.setAttribute("First_Name", Fname);
                    session.setAttribute("Email", Email);
                    session.setAttribute("usertype", "user");
                } else {
                    msg = "Sign Up Unsuccessful";
                }
            } else {
                msg = "Confirm password Does not Match";
            }
            session.setAttribute("msg", msg);
            response.sendRedirect(path + "?msg=" + msg);
        } catch (Exception e) {
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
