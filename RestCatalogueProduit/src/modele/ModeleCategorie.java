package modele;

import java.util.ArrayList;
import java.util.List;

import dao.IcatalogueMetier;
import dao.ImpCategorie;
import metier.Categorie;



public class ModeleCategorie {

	private Categorie cat;
	private IcatalogueMetier metierCatego = new ImpCategorie();
	private List<Categorie> lstCatego=new ArrayList<Categorie>();
	
	
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public IcatalogueMetier getMetierCatalogue() {
		return metierCatego;
	}
	public void setMetierCatalogue(IcatalogueMetier metierCatalogue) {
		this.metierCatego = metierCatalogue;
	}
	public List<Categorie> getLstCatego() {
		return lstCatego;
	}
	public void setLstCatego(List<Categorie> lstCatego) {
		this.lstCatego = lstCatego;
	}
	
	//
	
	public Categorie ajouterCategorie( Categorie c)
	{
		return metierCatego.ajouterCategorie(c);
	}
	
	
	public List<Categorie> listerCatego()
	{ 
		lstCatego=metierCatego.listCategories();
		return lstCatego;
		}
	
	///////Categorie////
	public void modifierCatego(Categorie c)
	{  
		metierCatego.updateCategorie(c);
	}
	
	/////////

	public void supprimerCatego(Long idC) 
	{
		metierCatego.deleteCategorie(idC);
	
	}
	
	
	public Categorie getCatego(Long id)
	{
		return metierCatego.getCategorie(id);
	}
	
}
