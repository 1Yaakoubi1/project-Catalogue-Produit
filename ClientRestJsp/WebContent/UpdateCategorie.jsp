<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ page import="java.util.List,modele.entities.Categorie,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Modification des Catégories</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Catégories</div>
			<div class="card-body">
				
				<form action="./Update" method="post">
				
					<% Categorie c=(Categorie)request.getAttribute("c"); %>
				
					<div  class="form-group">
						<label class="control-label">Identifiant :</label> 
						<input type="text" name="IdC" class="form-control" value='<%=c.getIdCat() %>'/>
					</div>
					<div  class="form-group">
						<label class="control-label">Nom_Categorie :</label> 
						<input type="text" name="nomC" class="form-control" value='<%=c.getNom() %>'/>
					</div>
					<div  class="form-group">
						<label class="control-label">Photo_Categorie:</label> 
						<input type="text" name="photoC" class="form-control" value='<%=c.getPhoto() %>'/>
					</div>
					<div>
						<button type="submit" class="btn btn-primary" >Modifier</button>
						<a href="/ClientRestJsp/listerCategories" style="color:deeppink"> Lister les Categories</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>