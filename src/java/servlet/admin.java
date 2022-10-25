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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.Demande;
import jpa.Employee;
import jpa.EmployeePK;
import session.DemandeFacadeLocal;
import session.EmployeeFacadeLocal;

/**
 *
 * @author hamdi
 */
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    @EJB
    private DemandeFacadeLocal demandeFacade;

    @EJB
    private EmployeeFacadeLocal employeeFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dir = request.getParameter("dir");
        if(dir.equals("liste_emp")){
            List<Employee> liste_emp = employeeFacade.findAll();
            request.setAttribute("liste_emp",liste_emp);
            request.getRequestDispatcher("liste_emp.jsp").forward(request, response);
        }else if(dir.equals("doc")){ 
            List<Demande> liste_dem = demandeFacade.findAll();
            request.setAttribute("liste_dem", liste_dem);
            request.getRequestDispatcher("confir_demande.jsp").forward(request, response);
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Demande d = null;
        String act = request.getParameter("act");
        String log = request.getParameter("login");
        String mp = request.getParameter("mp");
        String ids = request.getParameter("id");
        if(ids != null){
        int id  =  Integer.parseInt(request.getParameter("id"));
        d = demandeFacade.find(id);
        }
        EmployeePK pk = new EmployeePK();
        pk.setLogin(log);
        pk.setMotDePasse(mp);
        Employee em = employeeFacade.find(pk);
        
        switch (act) {
            case "supp":
                employeeFacade.remove(em);
                response.sendRedirect("/projetJEE/admin?dir=liste_emp");
                break;
            case "upd":
                request.setAttribute("e", em);
                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
            case "conf":
                em.setConf(true);
                employeeFacade.edit(em);
                response.sendRedirect("/projetJEE/admin?dir=liste_emp");
                break;
            case "accept":
                d.setEtat("accepté");
                demandeFacade.edit(d);
                response.sendRedirect("/projetJEE/admin?dir=doc");
                break;
            case "refus":
                d.setEtat("refusé");
                demandeFacade.edit(d);
                response.sendRedirect("/projetJEE/admin?dir=doc");
                break;
            default:
                break;
        }
    }


}
