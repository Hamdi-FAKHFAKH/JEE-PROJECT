/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpa.Demande;
import jpa.Employee;
import jpa.EmployeePK;
import session.DemandeFacadeLocal;
import session.EmployeeFacadeLocal;

public class emp extends HttpServlet {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    @EJB
    private DemandeFacadeLocal demandeFacade;
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession ();
        String dir = request.getParameter("dir");
         EmployeePK epk = new EmployeePK();
            epk.setLogin((String) session.getAttribute("log"));
            epk.setMotDePasse((String) session.getAttribute("mp"));
            Employee e = employeeFacade.find(epk);
        if(dir.equals("upd_compte")){
            request.setAttribute("e",e);
            request.getRequestDispatcher("update_emp.jsp").forward(request, response);   
        }else if(dir.equals("demande")){
            response.sendRedirect("remplir_demande.jsp");
        }else if(dir.equals("cons_dem")){
            List<Demande> list = demandeFacade.findAll();
            request.setAttribute("liste", list);
            request.getRequestDispatcher("consult_demande.jsp").forward(request, response);
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int id  =  Integer.parseInt(request.getParameter("id"));
      String nom =  request.getParameter("nom");
      String pre =  request.getParameter("pre");
      String type =  request.getParameter("type");
            Demande d = new Demande();
            d.setId(id);
            d.setNomEmp(nom);
            d.setPrenomEmp(pre);
            d.setType(type);
            d.setEtat("sous traitement");
        try{
        demandeFacade.create(d);
        String s = "ligne inseré avec succés ";
        request.setAttribute("msg1",s);
        request.getRequestDispatcher("remplir_demande.jsp").forward(request, response);
        }catch(Exception ex){
          String s = "ligne deja existe";
          request.setAttribute("msg", s);
          request.getRequestDispatcher("remplir_demande.jsp").forward(request, response);
        }
      }
       
    

    

}
