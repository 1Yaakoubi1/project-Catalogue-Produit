package service;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import metier.Categorie;
import metier.Produit;
import modele.ModeleCategorie;
import modele.ModeleProduit;

@Singleton

@Path("/catalogue")
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
								

public class CatalogueRestService {
	
	private ModeleCategorie modeleCatego;
	private ModeleProduit modeleProd;
	
		
		public CatalogueRestService() {
			modeleCatego = new ModeleCategorie();
			modeleProd = new ModeleProduit();
	}
		
		@POST
		@Path("/categories")
		@Consumes(MediaType.APPLICATION_JSON)
		public Categorie saveCategorie(Categorie c)
		{
			return modeleCatego.ajouterCategorie(c);
			
		}

		
		
		@GET
		@Path("/categories")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Categorie> consulterCategories()
		{
			return modeleCatego.listerCatego();
	
		}
		
		
		@GET
		@Path("/categories/{idCat}")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public Categorie getCategorie(@PathParam(value="idCat")Long idCat) {
			return modeleCatego.getCatego(idCat);
		}
		
		
///////////////////
		@PUT
		@Path("/categories")
		public void updateCatego(Categorie c)
		{
		 modeleCatego.modifierCatego(c);
		}
		
	///////////////	
		@DELETE
		@Path("/categories")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void deleteCategorie(@FormParam(value="idCat") Long idCat)
		{
			 modeleCatego.supprimerCatego(idCat);
		}
		
		//
		
		@DELETE
		@Path("/categories/{idCat}")
		//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void deleteCategorie2(@PathParam(value="idCat") Long idCat)
		{
			 modeleCatego.supprimerCatego(idCat);
		}
		
//******************************PRODUIT***********************************************************************************************/
	
		@GET
		@Path("/allproduits")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Produit> produits()
		{
			return modeleProd.listerProd();
	
		}
		
		
		
		@GET
		@Path("/produits/{idProd}")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public Produit getProduit(@PathParam(value="idProd")Long idProd) {
			return modeleProd.getProd(idProd);
		}
		
		
		@GET
		@Path("/categories/{idCat}/produits")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Produit> produitsParCat(@PathParam(value="idCat")Long idCat)
		{
			return modeleProd.produitsParCatego(idCat);
	
		}	
		
		////////
		@GET
		@Path("/produits")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public ArrayList<Produit> produitsParMC(@QueryParam(value="mc")String mc)
		{
			return   modeleProd.produitsParMC(mc);
	
		}
		///////////////////////////////////
		@GET
		@Path("/MCproduits/{mc}")
		//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public ArrayList<Produit> produitsParMC2(@PathParam(value="mc")String mc)
		{
			return   modeleProd.produitsParMC(mc);
	
		}
		
		
		/////////////////////////
		
		@PUT
		@Path("/produits")
		public Produit updateProd(Produit p)
		{
			return modeleProd.modifierProduit(p);
		}
		
		
		@DELETE
		@Path("/produits")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void deleteProduit(@FormParam(value="idProd") Long idProd)
		{
			modeleProd.supprimerProduit(idProd);
		}
		
		
		@POST
		@Path("/produits")
		//@Consumes(MediaType.APPLICATION_JSON)
		public Produit saveProduit(Produit p)
		{
			return modeleProd.ajouterProduit(p);
			
		}
		
		
		@DELETE
		@Path("/produits/{idprod}")
		//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public void deleteProduit2(@PathParam(value="idprod") Long idprod)
		{
			modeleProd.supprimerProduit(idprod);
		}
		

}
