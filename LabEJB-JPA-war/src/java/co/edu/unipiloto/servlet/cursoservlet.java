/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entitys.Curso;
import co.edu.unipiloto.session.CursoFacadeLocal;
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
@WebServlet(name = "cursoservlet", urlPatterns = {"/cursoservlet"})
public class cursoservlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;
    Curso curso;
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
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("cursotId"));
        String nombre = request.getParameter("nombre");
        int creditos = Integer.parseInt(request.getParameter("creditos"));
        int semestre = Integer.parseInt(request.getParameter("semestre"));
        int estudiantes = Integer.parseInt(request.getParameter("estudiantesAdmitidos"));
        
        curso = new Curso(id,nombre,creditos,semestre,estudiantes);
        
        
        switch(action){
            
                case "Add":
                    cursoFacade.create(curso);
                    break;
                case "Edit":
                    cursoFacade.edit(curso);
                    break;
                case "Delete":
                    cursoFacade.remove(curso);
                    break;
                case "Search":
                    cursoFacade.find(curso.getCursoid());
                    break;
            }
              response.setContentType("text/html;charset=UTF-8");
              request.setAttribute("curso", curso);
              request.setAttribute("allCursos", cursoFacade.findAll());
              request.getRequestDispatcher("cursoInfo.jsp").forward(request, response);
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
