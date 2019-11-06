/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        
        
        Pais argelia = new Pais();
        Pais sudafrica = new Pais();
        Pais egipto = new Pais();
        Pais nigeria = new Pais();
        Pais etiopia = new Pais();

        argelia.setPais("Argelia");
        argelia.setCapital("Argel");
        argelia.setGentilicio("Argelianos");
        argelia.setIdioma("Árabe / Bereberes");
        argelia.setMoneda("Dinar Argelino");
        
        sudafrica.setPais("Sudafrica");
        sudafrica.setCapital("Ciudad del Cabo");
        sudafrica.setGentilicio("Sudafricanos");
        sudafrica.setIdioma("Inglés, Afrikááns, Setsuana, 7 mas...");
        sudafrica.setMoneda("Rand");
        
        nigeria.setPais("Nigeria");
        nigeria.setCapital("Abuya");
        nigeria.setGentilicio("Nigerianos");
        nigeria.setIdioma("Inglés");
        nigeria.setMoneda("Naira");
        
        egipto.setPais("Egipto");
        egipto.setCapital("El Cairo");
        egipto.setGentilicio("Egipcios");
        egipto.setIdioma("Árabe");
        egipto.setMoneda("Libra");
        
        etiopia.setPais("Etiopia");
        etiopia.setCapital("Adis Abeba");
        etiopia.setGentilicio("Etiope");
        etiopia.setIdioma("Amhárico");
        etiopia.setMoneda("Birr Etiope");
        
        
        ArrayList lista = new ArrayList();
        
        lista.add(nigeria);
         Iterator it = lista.iterator();

        //verifica si existe otro elemento con el método hasNext()

        while ( it.hasNext() ) { 
            Object objeto = it.next(); 
            //Pais nigeria = (Pais)objeto; 
            System.out.println(nigeria); 
        } 
                
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(request.getParameter("pais").equals("nigeria")){
           // out.println("<font size=5>" + request.getParameter("pais") + "</font><br>");
                out.println("<font size=5> Pais: " + nigeria.getPais() + "</font><br>");
                out.println("<font size=5> Capital: " + nigeria.getCapital() + "</font><br>");
                out.println("<font size=5> Gentilicio: " + nigeria.getGentilicio() + "</font><br>");
                out.println("<font size=5> Idioma: " + nigeria.getIdioma() + "</font><br>");
                out.println("<font size=5> Moneda: " + nigeria.getMoneda() + "</font><br>");
            }
            out.println("</body>");
            out.println("</html>");
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
