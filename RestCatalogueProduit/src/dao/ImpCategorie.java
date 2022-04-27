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





public class ImpCategorie  implements IcatalogueMetier {
	


		private Connection connexion=SingletonConnexion.getConnection();

		@Override
		public Categorie ajouterCategorie(Categorie c) {
			
			try {
				PreparedStatement ps=connexion.prepareStatement ("insert into categorie (idCat, nom, photo)values(?,?,?)");
				ps.setLong(1, c.getIdCat());
				ps.setString(2, c.getNom());
			    ps.setString(3, c.getPhoto());
			   
			    ps.executeUpdate();
			    ps.close();
			    
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			return c;
		}

		@Override
		public List<Categorie> listCategories() {
			
			List<Categorie> lst=new ArrayList<Categorie>();
		
			try { 
				PreparedStatement ps=connexion.prepareStatement("select * from categorie");
		       ResultSet rs=ps.executeQuery();
		       while(rs.next())
		       { Categorie c=new Categorie();
		       
		       	c.setIdCat(rs.getLong(1));
		    	c.setNom(rs.getString(2));
		    	c.setPhoto(rs.getString(3));
		    	  
		    	   
		    	   lst.add(c);
		       }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lst;
			
		}


		@Override
		public Categorie updateCategorie(Categorie c) {
		
			try {
				PreparedStatement ps= connexion.prepareStatement("UPDATE categorie SET nom= ?,photo= ? WHERE idCat= ?");
				
				ps.setString(1,c.getNom());
			    ps.setString(2, c.getPhoto());
			    ps.setLong(3, c.getIdCat());
			    
			    
				ps.executeUpdate();
				ps.close();
				
				
				} catch (SQLException e1) {
				e1.printStackTrace();
				}
			return c;
		}
		
		
		
		
		

		@Override
		public void deleteCategorie(Long idCat) {
		
		try {
				PreparedStatement ps= connexion.prepareStatement("DELETE FROM categorie where idCat=?");
			
				ps.setLong(1, idCat);
				ps.executeUpdate();
				ps.close();
			
				} 
			
			catch (SQLException e) {
				e.printStackTrace();
				
				}
			
			
		}
		
		
	
		public Categorie getCategorie(Long idc) {
			
			 Categorie c=new Categorie();
				try {
					PreparedStatement ps = connexion.prepareStatement("select * from categorie where idCat=?");
				
			      ps.setLong(1, idc);  
			     
				ResultSet rs=ps.executeQuery();
			       while(rs.next())
			       { 
			    	   c.setIdCat(rs.getLong(1));
			    	   c.setNom(rs.getString(2));
			    	   c.setPhoto(rs.getString(3));
			    	  
			    	  
			       }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return c;
		}
		
		


		@Override
		public void deleteProduit(Long idProd) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public ArrayList<Produit> produitsParCatego(Long idCat) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Produit> listProduits() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Produit> produitsParMotcle(String mc) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Produit updateProduit(Produit p) {
			// TODO Auto-generated method stub
			return null;
		}	
		
		@Override
		public Produit ajouterProduit(Produit p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Produit getProduit(Long idProd) {
			// TODO Auto-generated method stub
			return null;
		}

	

	
		
}