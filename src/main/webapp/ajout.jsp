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
<form action="addProduit" method="post">
  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom">
  </div>
  <div class="mb-3">
    <label for="prix" class="form-label">Prix</label>
    <input type="number" class="form-control" name="prix" id="prix">
  </div>
 <div class="mb-3">
    <label for="quantite" class="form-label">Quantite</label>
    <input type="number" class="form-control"  name="quantite" id="quantite">
  </div>
    <div class="mb-3">
    <label for="categorie" class="form-label">Categorie</label>
 <select name="idcat" class="form-select">
 <c:forEach var="cat" items="${categories}">
 <option value="${cat.id}">${cat.nom}</option>
 </c:forEach>
 </select>
  </div>
  <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</body>
</html>