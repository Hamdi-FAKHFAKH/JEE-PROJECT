<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Update</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <style>
        form{
            width: 900px;
            margin :auto ;
        }
    </style>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="2.jpg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      HF-DEV
    </a>
  </div>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="espace_emp.jsp" style="  width: 100px ;font-size:1.2em !important;">Acceuil</a>
    </li>
    <li class="nav-item active">
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
        <h4 style="margin-left: 30px;"> Modifier Compte </h4>
        <br>
        
        <form action="/projetJEE/update" method="post">
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">ID</label>
      <input type="number" class="form-control" id="inputEmail4" placeholder="ID" name="id" required value="${e.id}" disabled>
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">NOM</label>
      <input type="text" class="form-control" id="inputPassword4" placeholder="nom" name="nom" required value="${e.nom}" disabled>
    </div>
      <div class="form-group col-md-4">
      <label for="inputPassword4">PRENOM</label>
      <input type="text" class="form-control" id="inputPassword4" placeholder="prenom" name="pre" required value="${e.prenom}" disabled>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="adresse" name="adr" required value="${e.adresse}" >
  </div>
   <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputdate">Date</label>
      <input type="date" class="form-control" id="inputdate" placeholder="date" name="date" required value="${e.dateN}" >
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">Telephone </label>
      <input type="number" class="form-control" id="inputPassword4" placeholder="telephone" name="tel" required value="${e.telephone}" >
    </div>
      <div class="form-group col-md-4">
      <label for="inputPassword4">Email</label>
      <input type="email" class="form-control" id="inputPassword4" placeholder="email" name="email" required value="${e.email}">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputEmail4">Service</label>
      <input type="text" class="form-control" id="inputEmail4" placeholder="service" name="service" required value="${e.service}">
    </div>
    <div class="form-group col-md-4">
      <label for="inputPassword4">Login </label>
      <input type="text" class="form-control" id="inputPassword4" placeholder="log" name="log" required value="${e.getEmployeePK().login}" >
    </div>
      <div class="form-group col-md-4">
      <label for="inputPassword4">Mot de passe </label>
      <input type="password" class="form-control" id="inputPassword4" placeholder="mot de passe " name="mp" required value="${e.getEmployeePK().motDePasse}" >
    </div>
  </div>
    <input type="hidden" value="maj_emp" name="maj">
   
    <button type="submit" class="btn btn-primary" onclick="fn()">Sign in</button>
</form>
     <script>
        //fonction permet de activer les inputs pour que le servlet peut lire ses valeurs 
     function fn(){
        for(i =0;i<10;i++){
        document.getElementsByClassName("form-control")[i].disabled = false;
        }
     }
    </script>
    </body>
</html>
