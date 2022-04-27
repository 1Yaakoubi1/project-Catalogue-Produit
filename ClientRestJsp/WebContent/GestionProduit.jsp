<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List,modele.entities.Categorie,java.util.ArrayList" %>
<%@ page import="java.util.List,modele.entities.Produit,java.util.ArrayList" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<style>

</style>

<title>Gestion Produit</title>
<nav class="navbar navbar-expand-md navbar-dark" 
			style="background-color: lightpink;  text-align:center ">
			<div >
				<a href="https://www.javaguides.net" class="navbar-brand" style="text-align: center"><br> Gestion des Produits </a>				
			</div>
		</nav>
</head>



<body>

<h4>
<br>
<a href="/ClientRestJsp/AjoutProduit.html" style=" color:deeppink"> Ajouter un produit </a> <br>
<a href="/ClientRestJsp/listerProduits" style=" color:deeppink"> Lister les produits</a> <br> </h4>


<div> 

<form action="./listerProduitsParCat" method="get">
<div class="form-group">

<label class="control-label">Identifiant Categorie </label>
<input type="text" name="idRC" style=" height:30px" size="5" />
<button type="submit" class="btn btn-primary" style="background-color: lightpink"  >Lister par categorie</button>
</div>
 </form>

</div>



 <h4 style=" color:deeppink" > Rechercher les produits</h4>


<div>
<form action="./rechercheP/{idp}" method="get">
<div class="form-group">

<label class="control-label">Identifiant produit  </label>
<input type="text" name="idp" style=" height:30px" size="5" />
<button type="submit" class="btn btn-primary" style="background-color: lightpink"  >chercher</button>
</div>
 </form>
</div>




<div> 

<form action="./rechercheMC" method="get">
<div class="form-group">

<label class="control-label">Mot clé  </label>
<input type="text" name="mc" style=" height:30px" size="8" />
<button type="submit" class="btn btn-primary" style="background-color: lightpink"  >chercher</button>
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
<th>Id Produit </th>
<th>Designation </th>
<th>Prix </th>
<th>Photo </th>
<th>Identifiant Categorie </th>
<th>Edition</th>
<th>Suppression</th>
</tr>
<% ArrayList<Produit> lst=new ArrayList<Produit>();

lst=(ArrayList<Produit>)request.getAttribute("lstprod");

if (lst != null){
for(Produit p:lst)
{
%>
<tr>
<td><%=p.getIdProd() %></td>
<td><%=p.getDesignation() %></td>
<td><%=p.getPrix() %></td>
<td><%=p.getPhoto() %></td>
<td><%=p.getCategorie().getIdCat() %></td>


<td><a href="/ClientRestJsp/editP?IdP=<%=p.getIdProd() %>">Edit</a></td>
							
<td><a onclick="return confirm('Etes-vous sûr ?')" href="/ClientRestJsp/delete/{idp}?idp=<%=p.getIdProd() %>">Supprimer</a></td>

</tr>
<%}} %>

</table>
</div>
</div>
</div>
</div>

</body>
</html>