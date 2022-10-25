<%-- 
    Document   : consult_demande
    Created on : 20 déc. 2021, 16:53:44
    Author     : hamdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>les Demandes </title>
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
      <a class="nav-link" href="espace_emp.jsp" style="  width: 100px ;font-size:1.2em !important;">Acceuil</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/projetJEE/emp?dir=upd_compte"style="width: 190px !important ; font-size:1.2em !important;"> Modifier Compte </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/projetJEE/emp?dir=demande" style="width: 210px !important; font-size:1.2em !important;"> Passer une Demande</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/projetJEE/emp?dir=cons_dem" style="width: 210px !important; font-size:1.2em !important;"> Consulter Demandes </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="/projetJEE/" style="width: 210px !important; font-size:1.2em !important;"> Deconnexion </a>
    </li>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  </ul>
</nav>
        <br>
        <h3 style="margin-left: 20px;">Liste des Demande</h3>
        <br>
<table class="table" style="width: 1300px; margin: auto">
        <thead class="thead-dark">
            <tr>
                
                <th>Code</th> <th>Nom Employé</th> <th>Prénom Employé </th> <th>Type</th> <th>Etat</th>
            </tr>
            <%--récupérer le tableau envoyé par le servlet(rs)et le parcourir--%>
            <c:forEach var="d" items= "${liste}" >
                <c:if test="${d.getNomEmp() == sessionScope.nom && d.getPrenomEmp() == sessionScope.prenom }">
                <tr>
                    <td>${d.getId()}</td>
                    <td>${d.getNomEmp()}</td>
                    <td>${d.getPrenomEmp()}</td>
                    <td>${d.getType()}</td>
                    <td>${d.getEtat()}</td>
                </tr>
                </c:if>
            </c:forEach>
        </thead>
   <table>
    </body>
</html>
