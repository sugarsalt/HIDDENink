/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact;

import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hi
 */
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Mails;

public class Mail extends HttpServlet {

    private static String HOST = "smtp.gmail.com";
    private static String USER = "sugar94salt@gmail.com";
    private static String PASSWORD = "torqueqe";
    private static String PORT = "110";
    //private static String FROM = "";
    private static String TO = "sugar94salt@gmail.com";
    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static String SUBJECT = "ENQUIRY";
    //private static String TEXT = "This is a test message from my java application. Just ignore it";

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
    public static synchronized void send(String FROM, String TEXT) {
        //Use Properties object to set environment properties
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "110");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        try {

            //Obtain the default mail session
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);

            //Construct the mail message
            MimeMessage message = new MimeMessage(session);
            message.setText(TEXT);
            message.setSubject(SUBJECT);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(TO));
            message.saveChanges();

            //Use Transport to deliver the message
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String path = "Contactus.jsp";
        try {
            String dirname = request.getHeader("host") + getServletContext().getContextPath();
            String dirname1 = getServletContext().getRealPath("/");
            StringBuilder s1 = new StringBuilder(dirname1);
            s1.replace(s1.length() - 11, s1.length(), "\\web\\uploads");
            dirname = s1.toString();

            MultipartRequest multi = new MultipartRequest(request, dirname, 1000 * 1024 * 1024,
                    new com.oreilly.servlet.multipart.DefaultFileRenamePolicy());
            String Name = multi.getParameter("name");
            String from = multi.getParameter("EmailID");
            String ContactNo = multi.getParameter("ContactNo");
            String message = multi.getParameter("message");

            Mails mails = new Mails();
            mails.setEmail(from);
            mails.setMail(message);
            mails.AddMails();

            String Header = "DEAR, ADMIN :\n\nSUBJECT : TO ENQUIRY\n\nPROBLEM : ";
            String Footer = "\nContact Number : " + ContactNo + "\n\nFrom : " + Name + "\nVia @HIDDENink";
            message = Header + message + "\n" + Footer;
            System.out.println(from + "###" + message);
            Mail.send(from, message);
            System.out.println("Mail sent successfully!");


            String msg = "Mail_Sent";
            HttpSession session = request.getSession();
            session.setAttribute("msg", msg);
            response.sendRedirect(path + "?msg=" + msg);

        } catch (Exception e) {
            System.out.println("Error is Here my dear in Mail.java Servlet");
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
