/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entitys.Estudiante;
import co.edu.unipiloto.session.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael
 */
@WebServlet(name = "estudianteservlet", urlPatterns = {"/estudianteservlet"})
public class estudianteservlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    Estudiante estudiante;
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
        String action =  request.getParameter("action");
        String idStr = request.getParameter("studentId");
        int id = Integer.parseInt(idStr);
        
        String firstNameStr = request.getParameter("firstName");
        String lastNameStr = request.getParameter("lastName");
        
        String yearStr = request.getParameter("yearLevel");
        int year = Integer.parseInt(yearStr);

        estudiante = new Estudiante(id,firstNameStr,lastNameStr,year);
        
        
        switch(action){
            
                case "Add":
                    estudianteFacade.create(estudiante);
                    break;
                case "Edit":
                    estudianteFacade.edit(estudiante);
                    break;
                case "Delete":
                    estudianteFacade.remove(estudiante);
                    break;
                case "Search":
                    estudianteFacade.find(id);
                    break;
            }
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("student", estudiante);
        request.setAttribute("allStudents", estudianteFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
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
