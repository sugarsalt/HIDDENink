/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageStegno;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Messages;

/**
 *
 * @author hi
 */
public class Encryption extends HttpServlet {

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
        String path = "Tools/imagesteg.jsp";
        String NewMessage = "";
        String NewMessage2 = "";
        try {
            String dirname = request.getHeader("host") + getServletContext().getContextPath();
            String dirname1 = getServletContext().getRealPath("/");
            StringBuilder s1 = new StringBuilder(dirname1);
            s1.replace(s1.length() - 11, s1.length(), "\\web\\uploads");
            dirname = s1.toString();

            MultipartRequest multi = new MultipartRequest(request, dirname, 1000 * 1024 * 1024,
                    new com.oreilly.servlet.multipart.DefaultFileRenamePolicy());


            String Nmessage = multi.getParameter("message");
            System.out.println(Nmessage);
            Nmessage = Nmessage.toLowerCase();
            MonoalhabeticCipher obj1 = new MonoalhabeticCipher();
            NewMessage = obj1.doEncryption(Nmessage);
            ImageEncryptionAndDecryption obj = new ImageEncryptionAndDecryption();
            NewMessage2 = obj.encrypt(NewMessage);
            System.out.println("Encrypted/Decrypted Message=" + NewMessage2);
            response.sendRedirect(path + "?NewMessage2=" + NewMessage2);

            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("Email");

            Messages ob = new Messages();
            ob.setEmail(email);
            ob.setMessage(Nmessage);
            if (ob.AddMessages()) {
                System.out.println("DONE");
            } else {
                System.out.println("NOT DONE");
            }

            /* String temp = Nmessage;
             File f = new File(dirname + "\\Image.txt");
             FileOutputStream fos = new FileOutputStream(f);
             fos.write(temp.getBytes());
             fos.flush();
             fos.close();*/

        } catch (Exception e) {
            System.out.println(e + "#######");
            path = "errorPage.jsp";
            String msg = e.getMessage();
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
