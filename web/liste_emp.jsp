<%-- 
    Document   : liste_emp
    Created on : 19 déc. 2021, 15:50:12
    Author     : hamdi
--%>

<%@page import="java.util.List"%>
<%@page import="jpa.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Liste Employer</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="2.jpg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      HF-DEV
    </a>
  </div>
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="espace_admin.jsp" style="  width: 100px ;font-size:1.2em !important;">Acceuil</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/projetJEE/admin?dir=liste_emp"style="width: 190px !important ; font-size:1.2em !important;">gérer les Employés</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/projetJEE/admin?dir=doc" style="width: 200px !important; font-size:1.2em !important;">gérer les Demandes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/projetJEE/" style="width: 210px !important; font-size:1.2em !important;"> Deconnexion </a>
    </li>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </ul>
</nav>
        <br>
        <h3 style="margin-left: 20px;">Liste des Employées</h3>
        <br>
        
        <table class="table" style="width: 1300px; margin: auto">
            <thead class="thead-dark">
            <tr>
                
                <th>Code</th> <th>Nom</th> <th>Prénom</th> <th>Adresse</th> <th>DateN</th><th>Telephone</th> <th> Email </th> <th>Service</th><th>Login</th><th>MP</th><th>Conf</th>
            </tr>
            <%--récupérer le tableau envoyé par le servlet(rs)et le parcourir--%>
       <c:forEach var="e" items= "${liste_emp}" >
           <c:if test="${e.getAdmin() == false}">
        <tr>
        <td>${e.getId()}</td>
        <td>${e.getNom()}</td>
        <td>${e.getPrenom()}</td>
        <td>${e.getAdresse()}</td>
        <td>${e.getDateN()}</td>
        <td>${e.getTelephone()}</td>
        <td>${e.getEmail()}</td>
        <td>${e.getService()}</td>
        <td>${e.getEmployeePK().getLogin()}</td>
        <td>${e.getEmployeePK().getMotDePasse()}</td>
        <td>${e.isConf()}</td>
        <td>
            <form action="/projetJEE/admin" method="post">
                <input type="hidden" value="${e.getEmployeePK().getLogin()}" name="login">
                <input type="hidden" value="${e.getEmployeePK().getMotDePasse()}" name="mp">
                <input type="hidden" value="conf" name="act">
                <input type="submit" value="Confirmer">
            </form>
        </td>
        <td>
            <form action="/projetJEE/admin" method="post">
                <input type="hidden" value="${e.getEmployeePK().getLogin()}" name="login">
                <input type="hidden" value="${e.getEmployeePK().getMotDePasse()}" name="mp">
                <input type="hidden" value="supp" name="act">
                <input type="submit" value="Supprimer">
            </form>
        </td>
        <td>
            <form action="/projetJEE/admin" method="post">
                <input type="hidden" value="${e.getEmployeePK().getLogin()}" name="login">
                <input type="hidden" value="${e.getEmployeePK().getMotDePasse()}" name="mp">
                <input type="hidden" value="upd" name="act">
                <input type="submit" value="Modifier">
            </form>
        </td>
        </tr>
       </c:if>
         </c:forEach>
            </thead>
   <table>
    </body>
</html>
