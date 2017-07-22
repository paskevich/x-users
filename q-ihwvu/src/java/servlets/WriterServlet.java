/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Users;
import org.hibernate.Session;

/**
 *
 * @author paskevich
 */
public class WriterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Session session = utils.NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if(request.getParameter("edoradd").equals("add")){
            Users user = new Users();
            user.setFName(request.getParameter("fname"));
            user.setSName(request.getParameter("sname"));
            user.setUsername(request.getParameter("uname"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(format.parse(request.getParameter("birthday")));
            } catch(ParseException pe) {
                System.out.print(pe);
            }
            
            user.setIsActive(true);
            Date curDate = new Date();
            user.setCreatedTimeStamp(curDate);
            user.setLastTimeStamp(curDate);
            session.save(user);
            session.getTransaction().commit();
        } else {
            Users exsUser = (Users)session.get(Users.class, Long.parseLong(request.getParameter("edoradd")));
            exsUser.setFName(request.getParameter("fname"));
            exsUser.setSName(request.getParameter("sname"));
            exsUser.setUsername(request.getParameter("uname"));
            if(!request.getParameter("password").equals(""))
                exsUser.setPassword(request.getParameter("password"));
            exsUser.setEmail(request.getParameter("email"));
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                exsUser.setBirthday(format.parse(request.getParameter("birthday")));
            } catch(ParseException pe) {
                System.out.print(pe);
            }
            
            exsUser.setLastTimeStamp(new Date());
            session.save(exsUser);
            session.getTransaction().commit();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
