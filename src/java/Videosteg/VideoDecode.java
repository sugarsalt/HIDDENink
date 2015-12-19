/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Videosteg;

import Audiosteg.*;
import audiostegnogarphy.Decoder;
import audiostegnogarphy.Encoder;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Messages;
import videoStegagography.VideoEncoderAndDecoder;

/**
 *
 * @author hi
 */
public class VideoDecode extends HttpServlet {

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
        String path = "Tools/VideoSteg.jsp";
        String message = "";
        try {
            File f = new File("");

            String photo = "";
            int flag = 0;
            String dirname = request.getHeader("host") + getServletContext().getContextPath();
            String dirname1 = getServletContext().getRealPath("/");
            StringBuilder s1 = new StringBuilder(dirname1);
            s1.replace(s1.length() - 11, s1.length(), "\\web\\uploads");
            dirname = s1.toString();

            MultipartRequest multi = new MultipartRequest(request, dirname, 1000 * 1024 * 1024,
                    new com.oreilly.servlet.multipart.DefaultFileRenamePolicy());
            String filename = "";
            String outPath = "";

            Enumeration files = multi.getFileNames();
            while (files.hasMoreElements()) {
                String name = (String) files.nextElement();
                filename = multi.getFilesystemName(name);
                String original = multi.getOriginalFileName(name);
                String type = multi.getContentType(name);
                f = multi.getFile(name);
            }

            String filePath = dirname + "\\" + filename;
            System.out.println(filePath);
            int keyUsed = 1234;
            VideoEncoderAndDecoder decoder = new VideoEncoderAndDecoder();
            message = decoder.Audiodecrypt(f, keyUsed, dirname);
            System.out.println("6666");

            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("Email");

            Messages obj = new Messages();
            obj.setEmail(email);
            obj.setMessage(message);
            if (obj.AddMessages()) {
                System.out.println("DONE");
            } else {
                System.out.println("NOT DONE");
            }
            /*
             String temp = message;
             File f1 = new File(dirname + "\\"+filename.substring(0,filename.length()-4)+".txt");
             FileOutputStream fos = new FileOutputStream(f1);
             fos.write(temp.getBytes());
             fos.flush();
             fos.close();  **/

            response.sendRedirect(path + "?message=" + message);
        } catch (Exception e) {
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
