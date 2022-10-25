/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.Employee;
import jpa.EmployeePK;
import session.EmployeeFacadeLocal;

/**
 *
 * @author hamdi
 */
public class update extends HttpServlet {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email =  request.getParameter("email");
        String service =  request.getParameter("service");
        String log =  request.getParameter("log");
        String mp =  request.getParameter("mp");
        String adr =  request.getParameter("adr");
        int tel =  Integer.parseInt(request.getParameter("tel"));  
        String date = request.getParameter("date");
        String maj = request.getParameter("maj");
        String conf = request.getParameter("conf");
         EmployeePK pk = new EmployeePK();
        pk.setLogin(log);
        pk.setMotDePasse(mp);
        Employee em = employeeFacade.find(pk);
       if(maj.equals("maj_admin")){
            //EmployeePK npk = new EmployeePK();
            //npk.setLogin(newlog);
            //npk.setMotDePasse(newmp);
            //em.setEmployeePK(npk);
            em.setEmail(email);
            em.setService(service);
            if(conf.equals("true"))
                em.setConf(true);
            else
                em.setConf(false);
            employeeFacade.edit(em);
            response.sendRedirect("/projetJEE/admin?dir=liste_emp");
        }
        if(maj.equals("maj_emp")){
            em.setAdresse(adr);
            em.setTelephone(tel);
            em.setEmail(email);
            em.setDateN(date);
            em.setService(service);
            employeeFacade.edit(em);
            response.sendRedirect("/projetJEE/emp?dir=upd_compte"); 
        }
     
    }

}
