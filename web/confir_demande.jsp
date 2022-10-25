<%-- 
    Document   : confir_demande
    Created on : 20 déc. 2021, 11:26:18
    Author     : hamdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title> Confirmation Demande </title>
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
        <h3 style="margin-left: 20px;">Liste des Demandes </h3>
        <br>   
        
        
   <table class="table" style="width: 1300px; margin: auto">
        <thead class="thead-dark">
            <tr>
                
                <th>Code</th> <th>Nom Employé</th> <th>Prénom Employé </th> <th>Type</th> <th>Etat</th><th colspan="2" style="text-align: center;" > Action </th>
            </tr>
            <%--récupérer le tableau envoyé par le servlet(rs)et le parcourir--%>
            <c:forEach var="d" items= "${liste_dem}" >
                <tr>
                    <td>${d.getId()}</td>
                    <td>${d.getNomEmp()}</td>
                    <td>${d.getPrenomEmp()}</td>
                    <td>${d.getType()}</td>
                    <td>${d.getEtat()}</td>
                    <td style="text-align: center;">
                        <form action="/projetJEE/admin" method="post">
                            <input type="hidden" value="${d.getId()}" name="id">
                            <input type="hidden" value="accept" name="act">
                            <input type="submit" value="Accepté">
                        </form>
                    </td>
                    <td style="text-align: center;">
                        <form action="/projetJEE/admin" method="post">
                            <input type="hidden" value="${d.getId()}" name="id">
                            <input type="hidden" value="refus" name="act">
                            <input type="submit" value="Refusé">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </thead>
   <table>
    </body>
</html>
