package metier;

import java.io.Serializable;
import java.sql.Blob;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Categorie implements Serializable {
	
	
	
	private Long idCat;
	private String nom ;
	private String photo;
	
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}


	public Categorie(Long idCat, String nom, String photo) {
		super();
		this.idCat = idCat;
		this.nom = nom;
		this.photo = photo;
	}


	public Long getIdCat() {
		return idCat;
	}


	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nom=" + nom + ", photo=" + photo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
