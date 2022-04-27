<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List,modele.entities.Categorie,java.util.ArrayList" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<style>

</style>

<title>Gestion Categorie</title>
<nav class="navbar navbar-expand-md navbar-dark" 
			style="background-color: grey;  text-align:center ">
			<div >
				<a href="https://www.javaguides.net" class="navbar-brand" style="text-align: center"><br> Gestion des Categories </a>				
			</div>
		</nav>
</head>



<body>

<h3>
<br>
<a href="/ClientRestJsp/SaisieCategorie.html"> Ajouter une Categorie </a> <br>
<a href="/ClientRestJsp/listerCategories"> Lister les Categories</a> <br> </h3>
 <h3 style=" color:blue" > Rechercher une Categorie </h3>






<form action="./recherche/{idc}" method="get">
<div class="form-group">

<label class="control-label">Identifiant categorie  </label>
<input type="text" name="idc" style=" height:30px" size="5" />
<button type="submit" class="btn btn-primary" style="background-color: grey"  >chercher</button>
</div>
 </form>
</div>

<br><br>
<div class="container"  width="500pt">
<div class="card" align="center" width="500pt">
<div class="card-header">


<div align="center">
<table class="table table-striped">
<tr>
<th>Id </th>
<th>Nom </th>
<th>Photo </th>
<th>Edition</th>
<th>Suppression</th>
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

<td><a href="/ClientRestJsp/edit?IdC=<%=c.getIdCat() %>">Edit</a></td>
							
<td><a onclick="return confirm('Etes-vous sûr ?')" href="/ClientRestJsp/delete/{idd}?idd=<%=c.getIdCat() %>">Supprimer</a></td>

</tr>
<%}} %>

</table>
</div>
</div>
</div>
</div>

</body>
</html>