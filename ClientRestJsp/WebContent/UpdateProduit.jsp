<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page import="java.util.List,modele.entities.Categorie,java.util.ArrayList" %>
<%@ page import="java.util.List,modele.entities.Produit,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Modification des Produits</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Produits</div>
			<div class="card-body">
				
				<form action="./UpdateP" method="post">
				
					<% Produit p=(Produit)request.getAttribute("p"); %>
				
					<div  class="form-group">
						<label class="control-label">Identifiant  Produit </label> 
						<input type="text" name="IdP" class="form-control" value='<%=p.getIdProd() %>'/>
					</div>
					<div  class="form-group">
						<label class="control-label">Designation Produit </label> 
						<input type="text" name="designationP" class="form-control" value='<%=p.getDesignation() %>'/>
					</div>
					<div  class="form-group">
						<label class="control-label">Prix Produit</label> 
						<input type="text" name="prixP" class="form-control" value='<%=p.getPrix() %>'/>
					</div>
					<div  class="form-group">
						<label class="control-label">Photo Produit</label> 
						<input type="text" name="photoP" class="form-control" value='<%=p.getPhoto() %>'/>
					</div>
					<div  class="form-group">
						<label class="control-label">Identifiant Categorie</label> 
						<input type="text" name="idcategorie" class="form-control" value='<%=p.getCategorie().getIdCat() %>'/>
					</div>
					<div>
						<button type="submit" class="btn btn-primary" >Modifier</button>
						<a href="/ClientRestJsp/listerProduits" style="color:deeppink"> Lister les produits</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>