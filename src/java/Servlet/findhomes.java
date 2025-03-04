package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Traitement.Domicile ;
import java.util.ArrayList ;


@WebServlet(name = "findhomes", urlPatterns = {"/findhomes"})
public class findhomes extends HttpServlet {

    ArrayList<Domicile> list = new ArrayList() ;
    Domicile nouv = new Domicile() ;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String par = request.getParameter("type") ;
            if(par.equals("Localite")){
                nouv.Localite = request.getParameter("val") ;
            }
            else if(par.equals("Prix")){
                nouv.Prix = request.getParameter("val") ;
            }
            else{
                nouv.Type = request.getParameter("val") ;
            }
            list = nouv.rechercherDomicile(par) ;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet findhomes</title>");            
            out.println("</head>");
            out.println("<body>");
            for( Domicile e : list ){
                out.println("<h1>Servlet findhomes at " + e.Id +e.Localite+e.Prix+e.Proprio+e.Type+ "</h1>");
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
