<%@page import="com.dao.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

<%-- List<Produit>liste =(List<Produit>)request.getAttribute("listeP"); --%>
<table class="table table-hover">
<div class="my-3">
<a href="addProduit" class="btn btn-primary">Ajouter un nouveau produit</a>
</div>
<div class="my-3">
<a href="listeCategories" class="btn btn-primary">Liste Catégorie </a>
</div>

<div class="my-3">
<form action="findProduit" method="post">
 <input  type="search"  name="motcle">
 <input  type="submit"  value="Rechercher">
 </form>
</div>

<tr>
<th>ID </th>
<th>Nom </th>
<th>Prix</th>
<th>Quantite</th>
<th>Categorie</th>
</tr>
<%--for(Produit p:liste ){ --%>

<c:forEach var ="p" items="${listeP}">
<tr>
<td>${p.id}</td>
<td>${p.nom} </td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td>${p.categorie.nom}</td>
<td>
<a href="suppProduit?id=${p.id}" class="btn btn-danger" > Supprimer</a>
</td>
<td>
<a href="modifProduit?id=${p.id}" class="btn btn-warning" > Modification</a>
</td>
</tr>
<%--}--%>
</c:forEach>
</table>
</body>
</html>