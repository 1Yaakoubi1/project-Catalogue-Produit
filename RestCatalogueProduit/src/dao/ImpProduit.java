package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utilitaire.SingletonConnexion;
import metier.Categorie;
import metier.Produit;


public class ImpProduit  implements IcatalogueMetier {

	private Connection connexion=SingletonConnexion.getConnection();
	
	
	@Override
	public Produit ajouterProduit(Produit p) {

		try {
			PreparedStatement ps=connexion.prepareStatement ("insert into produit (idProd,designation,prix,photo,idCat)values(?,?,?,?,?)");
			ps.setLong(1,p.getIdProd());
			ps.setString(2, p.getDesignation());
		    ps.setDouble(3,p.getPrix());
		    ps.setString(4,p.getPhoto());
		    ps.setLong(5,p.getCategorie().getIdCat());
		   
		   
		    ps.executeUpdate();
		    ps.close();
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return p;
	}

	

	@Override
	public ArrayList<Produit> listProduits() {

		ArrayList<Produit> lst=new ArrayList<Produit>();
		
		
		try { 
			PreparedStatement ps=connexion.prepareStatement("select * from produit");
	       ResultSet rs=ps.executeQuery();
	       while(rs.next())
	       { Produit p=new Produit();
	         Categorie c = new Categorie();
	      
	       
	    	   p.setIdProd(rs.getLong(1));
	    		p.setDesignation(rs.getString(2));
	    		p.setPrix(rs.getDouble(3));
	    	   p.setPhoto(rs.getString(4));
	    	   c.setIdCat(rs.getLong(5));
	    	  p.setCategorie(c);
	    	   
	    	   
	    	   lst.add(p);
	       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}

	

	@Override
	public Produit updateProduit(Produit p) {
		
		try {
			PreparedStatement ps= connexion.prepareStatement("UPDATE produit SET designation=?,prix=?,photo=?,idCat=? WHERE idProd=?");
			
			ps.setString(1,p.getDesignation());
		    ps.setDouble(2,p.getPrix());
		    ps.setString(3,p.getPhoto());
		    ps.setLong(4,p.getCategorie().getIdCat());
		    ps.setLong(5,p.getIdProd());
		    
			ps.executeUpdate();
			ps.close();
			
			
			} catch (SQLException e1) {
			e1.printStackTrace();
			}
		return p;
	
	}

	@Override
	public void deleteProduit(Long idProd) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement ps= connexion.prepareStatement("DELETE FROM produit where idProd=?");
			
			ps.setLong(1, idProd);
			ps.executeUpdate();
			ps.close();
		
			} 
		
		catch (SQLException e) {
			e.printStackTrace();
			
				}}

	@Override
	public Produit getProduit(Long id) {
		
			Produit p=new Produit();
			Categorie c = new Categorie();
		try {
			PreparedStatement ps = connexion.prepareStatement("select * from produit where idProd=?");
		
	      ps.setLong(1, id);  
	     
		ResultSet rs=ps.executeQuery();
	       while(rs.next())
	       { 
	    	   p.setIdProd(rs.getLong(1));
	    	   p.setDesignation(rs.getString(2));
	    	   p.setPrix(rs.getDouble(3));
	    	   p.setPhoto(rs.getString(4));
	    	   
	    	   c.setIdCat(rs.getLong(5));
	    	   p.setCategorie(c);
	    	   
  
	       }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return p;
	}
	
	
	@Override
	public ArrayList<Produit> produitsParMotcle(String mc) {
	//
		ArrayList<Produit> lst=new ArrayList<Produit>();

		   String post_mc=mc+"%";
		   String pre_mc="%"+mc;
		   String full="%"+mc+"%";

		try { 
			PreparedStatement ps = connexion.prepareStatement("Select * from produit where designation LIKE ? OR Photo  LIKE ?");
			
			ps.setString(1, full);
			ps.setString(2, full);

			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   { 
				   Produit p=new Produit();
				   Categorie c = new Categorie();
				   
					   p.setIdProd(rs.getLong(1));
					   p.setDesignation(rs.getString(2));
					   p.setPrix(rs.getDouble(3));
					   p.setPhoto(rs.getString(4));
					   c.setIdCat(rs.getLong(5));
					   p.setCategorie(c);
	   
				   
				   lst.add(p);
			   	}
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return lst;	
		
	}
	
	@Override
	public ArrayList<Produit> produitsParCatego(Long id) {

		ArrayList<Produit> lst=new ArrayList<Produit>();
		
		
		try { 
			PreparedStatement ps=connexion.prepareStatement("select * from produit where idCat=? ");
			 ps.setLong(1, id); 
			 
	       ResultSet rs=ps.executeQuery();
	       while(rs.next())
	       { Produit p=new Produit();
	         Categorie c = new Categorie();
	      
	       
	    	   p.setIdProd(rs.getLong(1));
	    		p.setDesignation(rs.getString(2));
	    		p.setPrix(rs.getDouble(3));
	    	   p.setPhoto(rs.getString(4));
	    	   c.setIdCat(rs.getLong(5));
	    	  p.setCategorie(c);
	    	   
	    	   
	    	   lst.add(p);
	       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}
	
	
	
	//
	
	
	
	@Override
	public Categorie ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getCategorie(Long idc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategorie(Long id) {
		// TODO Auto-generated method stub
		
	}

	


	
	
}
