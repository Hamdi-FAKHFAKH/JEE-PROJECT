<%-- 
    Document   : espace_admin
    Created on : 19 déc. 2021, 13:40:24
    Author     : hamdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Espace Administrateur</title>
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
      <a class="nav-link" href="#" style="  width: 100px ;font-size:1.2em !important;">Acceuil</a>
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
        <h4 style="margin-left: 30px;">${sessionScope.nom} ${sessionScope.prenom} bienvenu dans votre espace Administrateur !</h4>
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
