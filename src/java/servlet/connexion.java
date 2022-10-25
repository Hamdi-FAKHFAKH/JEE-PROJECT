/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class connexion {
    public static Connection c = null;
   public static Statement st = null ;
     static {
        /* chargement de driver */
        try {    
        Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {
        System.out.println("erreur de chargement de driver ");
        }
        try {
        /* connexion à la base de donnée */
        c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/issat_intranet", "root", "");
        /* création de statement pour executer les requete SQL */
        st = c.createStatement();
        } 
        catch (SQLException ex) {
        System.out.println("erreur de connexion");
        }
    }
    public int ajoute_emp(int id,String nom , String prenom , String adresse , String d ,int tel,String email,String serv , String log , String mp){
        try {
            PreparedStatement ps = c.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?,0);");
            ps.setInt(1, id);
            ps.setString(2, nom);
            ps.setString(3, prenom);
            ps.setString(4, adresse);
            ps.setString(5, d);
            ps.setInt(6, tel);
            ps.setString(7, email);
            ps.setString(8, serv);
            ps.setString(9, log);
            ps.setString(10, mp);
            int a = ps.executeUpdate();
            return a;
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion"+ex.getMessage());
            return 0;
        }
    }
}
