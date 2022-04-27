<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="java.util.List,modele.entities.Categorie,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

</head>
<body>
<div class="container" width="500pt">
<div class="card" align="left" width="500pt">
<div class="card-header">
Saisies des Produit
</div>
<div class="card-body">
<form action="./recherche/{idc}" method="get">
<div class="form-group">

<div class="form-group">
<label class="control-label">entrer mot clé :
</label>
<input type="text" name="idc" class="form-control"/>
</div>

</div>

<button type="submit" class="btn btn-primary">chercher</button></div>


<div>


<div align="center">
<table class="table table-striped">
<tr>
<th>Id </th>
<th>Nom </th>
<th>Photo </th>
<th>Edition</th>
</tr>
<% ArrayList<Categorie> lst=new ArrayList<Categorie>();

lst=(ArrayList<Categorie>)request.getAttribute("lstcat");

if (lst != null){
for(Categorie c:lst)
{
%>
<tr>
<td><%=c.getIdCat() %></td>
<td><%=c.getNom() %></td>
<td><%=c.getPhoto() %></td>
</tr>
<%}} %>

</table>
</div>

</body>
</html>