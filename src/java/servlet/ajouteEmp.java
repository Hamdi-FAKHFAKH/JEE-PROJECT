
package servlet;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ajouteEmp extends HttpServlet {

    @EJB
    private EmployeeFacadeLocal employeeFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id  =  Integer.parseInt(request.getParameter("id"));
        String nom =  request.getParameter("nom");
        String pre =  request.getParameter("pre");
        String adr =  request.getParameter("adr");
        String date = request.getParameter("date");
        int tel =  Integer.parseInt(request.getParameter("tel"));
        String email =  request.getParameter("email");
        String service =  request.getParameter("service");
        String log =  request.getParameter("log");
        String mp =  request.getParameter("mp");
        PrintWriter out = response.getWriter();
        EmployeePK ep = new EmployeePK();
        ep.setLogin(log);
        ep.setMotDePasse(mp);
        Employee e = new Employee();
        e.setId(id);
        e.setNom(nom);
        e.setPrenom(pre);
        e.setAdresse(adr);
        e.setTelephone(tel);
        e.setDateN(date);
        e.setEmail(email);
        e.setAdmin(false);
        e.setEmployeePK(ep);
        e.setService(service);
        
        try{
        employeeFacade.create(e);
        response.sendRedirect("index.html");
        }
        catch(Exception ex){
            out.print("<h1>ligne deja existe</h1>");
        }
        
       
    }


}
