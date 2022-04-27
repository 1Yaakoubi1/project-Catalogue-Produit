package dao;

import java.util.ArrayList;
import java.util.List;

import metier.Categorie;
import metier.Produit;


public interface IcatalogueMetier   {
	
	public Categorie  ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie updateCategorie(Categorie c);
	public void deleteCategorie(Long id);
	public Categorie getCategorie(Long idc);
	

	public Produit  ajouterProduit(Produit p);
	public ArrayList<Produit> produitsParCatego(Long id);
	public ArrayList<Produit> listProduits();
	public ArrayList<Produit> produitsParMotcle(String mc);
	public Produit updateProduit(Produit p);
	public void deleteProduit(Long idProd);
	public Produit getProduit(Long id);
	
}

