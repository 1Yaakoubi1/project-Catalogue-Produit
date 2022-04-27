package modele;

import java.util.ArrayList;
import java.util.List;

import dao.IcatalogueMetier;
import dao.ImpProduit;
import metier.Categorie;
import metier.Produit;



public class ModeleProduit {
	
	
private Produit prod;
	
	private IcatalogueMetier metierprod=new ImpProduit();
	
	private ArrayList<Produit> lstProd=new ArrayList<Produit>();

	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

	public IcatalogueMetier getMetierprod() {
		return metierprod;
	}

	public void setMetierprod(IcatalogueMetier metierprod) {
		this.metierprod = metierprod;
	}

	public List<Produit> getLstProd() {
		return lstProd;
	}

	public void setLstProd(ArrayList<Produit> lstProd) {
		this.lstProd = lstProd;
	}
	
	
	
	//
	
	
	public Produit ajouterProduit(Produit prod)
	{
		return metierprod.ajouterProduit(prod);
	}
	
	
	public ArrayList<Produit> listerProd()
	{ 
		lstProd=metierprod.listProduits();
		return lstProd;
		}
	
	
	public Produit modifierProduit(Produit p)
	{  
		return metierprod.updateProduit(p);
	}

	public void supprimerProduit(Long idP) 
	{
	    metierprod.deleteProduit(idP);
	}
	
	
	public Produit getProd(Long id)
	{
		return metierprod.getProduit(id);
	}
	
	
	public ArrayList<Produit> produitsParMC(String mc)
	{
		lstProd=metierprod.produitsParMotcle(mc);
	return lstProd;
	}
	
	public List<Produit> produitsParCatego(Long idC)
	{
		lstProd=metierprod.produitsParCatego(idC);
	return lstProd;
	}
	

}
