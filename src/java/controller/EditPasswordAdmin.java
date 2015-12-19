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
import model.admins;

/**
 *
 * @author hi
 */
public class EditPasswordAdmin extends HttpServlet {

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
        String path = "Admin/Admin.jsp";
        String msg = "";
        try {
            /* TODO output your page here. You may use following sample code. */
            String Email = request.getParameter("Email").trim();
            String Oldpassword = request.getParameter("Oldpassword").trim();
            String Newpassword = request.getParameter("Newpassword").trim();
            String Confirmpassword = request.getParameter("Confirmpassword").trim();
            HttpSession session = request.getSession();

            admins obj = new admins();
            obj.setUsername(Email);
            obj.setPassword(Oldpassword);
            obj.setConfirmPassword(Confirmpassword);
            if (obj.AdminVerify()) {

                if (Newpassword.equals(Confirmpassword)) {
                    if (obj.EditPasswordAdmin()) {
                        msg = "Password Changed Successful";

                        session.setAttribute("Email", Email);
                        session.setAttribute("usertype", "admin");
                    } else {
                        msg = "Unsuccessful! Try Again";
                    }

                } else {
                    msg = "Unsuccessful! New and Confirm Password does not match";
                }
            } else {
                msg = "Unsuccessful! Old password is wrong";
            }
            session.setAttribute("msg", msg);
            response.sendRedirect(path + "?msg=" + msg);
        } catch (Exception e) {
            System.out.println(e);
            path = "../errorPage.jsp";
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
