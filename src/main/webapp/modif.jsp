<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.dao.Produit"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification Produit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

<%-- Produit p =(Produit)request.getAttribute("produit"); --%>

<form action="modifProduit" method="post">
    <input type="hidden"  name="id" value ="${produit.id}">

  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom" value ="${produit.nom}">
  </div>
  <div class="mb-3">
    <label for="prix" class="form-label">Prix</label>
    <input type="number" class="form-control" name="prix" id="prix" value ="${produit.prix}">
  </div>
 <div class="mb-3">
    <label for="quantite" class="form-label">Quantite</label>
    <input type="number" class="form-control"  name="quantite" id="quantite" value ="${produit.quantite}">
  </div>
  <select name="idcat" class="form-select">
 <c:forEach var="cat" items="${categories}">
    <option value="${cat.id}" <c:if test="${cat.id==produit.categorie.id}">selected</c:if>>${cat.nom}</option>
 </c:forEach>
 </select>
  <button type="submit" class="btn btn-primary">Modifier</button>
</form>
</body>
</html>