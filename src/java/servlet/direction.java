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
import javax.servlet.http.HttpSession;
import jpa.Employee;
import jpa.EmployeePK;
import session.EmployeeFacadeLocal;

public class direction extends HttpServlet {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("log");
        String mp = request.getParameter("mp");
        HttpSession session = request.getSession ();
        
        PrintWriter out = response.getWriter();
        EmployeePK ep = new EmployeePK();
        ep.setLogin(login);
        ep.setMotDePasse(mp);
        Employee e = new Employee();
        e.setEmployeePK(ep);
        try{
        Employee e_ex  = employeeFacade.find(ep);
        boolean b = e.getAdmin();
        String msg= "" ;
        if(e_ex != null){
            if (e_ex.isConf() == true && e_ex.getAdmin()== false )
                {
                session.setAttribute("nom", e_ex.getNom());
                session.setAttribute("prenom", e_ex.getPrenom());
                session.setAttribute("log", login);
                session.setAttribute("mp", mp);
                request.getRequestDispatcher("espace_emp.jsp").forward(request, response);
            }
            else if (e_ex.getAdmin() == true){
                session.setAttribute("nom", e_ex.getNom());
                session.setAttribute("prenom", e_ex.getPrenom());
                request.getRequestDispatcher("espace_admin.jsp").forward(request, response);
            } 
            else
                msg ="compte existe on attendant la confirmation de l' Admin";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
        }    
        else{
           msg = "compte n'existe pas"; 
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
           
        }
       
        }catch(NullPointerException ex){
            out.println("compte n'existe pas");
        }
        
    }
     
}
