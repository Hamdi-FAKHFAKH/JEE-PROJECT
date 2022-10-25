<%-- 
    Document   : espace_emp
    Created on : 19 déc. 2021, 13:28:36
    Author     : hamdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Espace Employé</title>
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
        <h4 style="margin-left: 30px;">${sessionScope.nom} ${sessionScope.prenom} bienvenu dans votre espace employée </h4>
    <br>
        <div class="card" style="width: 900px; margin: auto;">
  <div class="card-header">
    Acceuil
  </div>
  <div class="card-body">
      <blockquote class="blockquote mb-0"style="height: 400px">
     actualités 
    </blockquote>
  </div>
</div>
    </body>
</html>
