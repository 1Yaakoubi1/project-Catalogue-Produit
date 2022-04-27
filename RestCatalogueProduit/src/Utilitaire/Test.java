package Utilitaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IcatalogueMetier;
import dao.ImpCategorie;
import dao.ImpProduit;
import metier.Categorie;
import metier.Produit;
import modele.ModeleCategorie;
import modele.ModeleProduit;


public class Test {

	public static void main(String[] args) {

	/*	
	try (Connection con = SingletonConnexion.getConnection()) {
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	*/	
		
	ModeleCategorie modeleCatego = new ModeleCategorie();
		
		Categorie A = new Categorie(1L,"CatA","a.png");
		Categorie B = new Categorie(2L,"CatB","b.png");
		
		Categorie C = new Categorie(6L,"CatC","c.png");
		
		/*
		 * modeleCatego.ajouterCategorie(A);
			modeleCatego.ajouterCategorie(C);
		*/
		
		
		//modeleCatego.supprimerCatego(1L); 
		
		/*
		 * 
		 
	
	
		
		/*modeleCatego.ajouterCategorie(A);
		modeleCatego.ajouterCategorie(B);
		modeleCatego.ajouterCategorie(C);
		
		modeleCatego.ajouterCategorie(C);*/
		//modeleCatego.supprimerCatego(2L); 
		
		
	
	
		/*
		 * 	System.out.println("******************");
	
		
		System.out.println(modeleCatego.getCatego(3L).toString());
		
		
		A.setNom("CatA");
		modeleCatego.modifierCatego(A);
		
		System.out.println(A.toString());
		
		*/
		/*
		
		System.out.println("******************");
		
		 List<Categorie> lstcatego=new ArrayList<Categorie>();
	        lstcatego= modeleCatego.listerCatego();
	        for(Categorie catego:lstcatego)
	        {
	        	System.out.println(catego.getIdCat());
	        	System.out.println(catego.getNom());
	        	System.out.println(catego.getPhoto());
	        	System.out.println("------");
	        } 
		
		
		*/
		
		//*************PRODUIT*****************************
		
	        ModeleProduit modeleprod = new ModeleProduit();
	        
	        Produit prod1=new Produit(8L,"prod8",150,"prod8.png",A);
	        Produit prod6=new Produit(7L,"prod6",150,"photo6.png",A);
	        Produit prod7=new Produit(6L,"prod7",150,"ph7.jpg",A);
			Produit prod2=new Produit(5L,"prod2",50,"photo2",C);
	        
			Produit prod3=new Produit(2L,"prod3",50,"photo2",B);
			
			Produit prod4=new Produit(5L,"tv",50,"tv.png",B);
			Produit prod5=new Produit(6L,"smartphone",50,"smart.png",B);
			
			/*
			modeleprod.ajouterProduit(prod1);
			modeleprod.ajouterProduit(prod6);
			modeleprod.ajouterProduit(prod7);
			
			*/
			
			/*prod1.setCategorie(A);
			prod2.setCategorie(C);
			prod2.setCategorie(B);
			*/
			/*
			modeleprod.ajouterProduit(prod2);
			modeleprod.ajouterProduit(prod1);
			
			
			*/
			/*
			prod1.setDesignation("p1");
			
			prod2.setCategorie(A);
			modeleprod.modifierProduit(prod1);
			modeleprod.modifierProduit(prod2);
			*/
			
		//	modeleprod.supprimerProduit(2L);
			
			//System.out.println(modeleprod.getProd(1L));
			
			System.out.println("******************");
			
			
			
			//System.out.println(modeleprod.produitsParMC("prod"));
			

		/*	List<Produit> lstProd=new ArrayList<Produit>();
			 lstProd= modeleprod.produitsParCatego(2L);
		        for(Produit prod:lstProd)
		        {
		        	System.out.println(prod.getIdProd());
		        	System.out.println(prod.getDesignation());
		        	System.out.println(prod.getPrix());
		        	System.out.println(prod.getPhoto());
		        	System.out.println(prod.getCategorie().getIdCat());
		        	System.out.println("------");
		        }
			*/
			System.out.println("******************");
		
	/*
			List<Produit> lstProdList=new ArrayList<Produit>();
			lstProdList= modeleprod.listerProd();
		        for(Produit prod:lstProdList)
		        {
		        	System.out.println(prod.getIdProd());
		        	System.out.println(prod.getDesignation());
		        	System.out.println(prod.getPrix());
		        	System.out.println(prod.getPhoto());
		        	System.out.println(prod.getCategorie().getIdCat());
		        	System.out.println("------");
		        } 
	        
	      
		*/
		
	
		
	

	}
	

}
