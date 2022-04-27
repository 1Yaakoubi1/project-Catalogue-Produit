package metier;

import java.io.Serializable;
import java.sql.Blob;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSetter;
@XmlRootElement
public class Produit   implements Serializable {

		private Long idProd;
		private String designation ;
		private double prix ;
		private String photo;
		private Categorie categorie;
		//
		private Long idc;
		//
		public Produit() {
			// TODO Auto-generated constructor stub
		}

		public Produit(Long idProd, String designation, double prix, String photo, Categorie categorie) {
			super();
			this.idProd = idProd;
			this.designation = designation;
			this.prix = prix;
			this.photo = photo;
			this.categorie = categorie;
		}
		//////////
		public Produit(Long idProd, String designation, double prix, String photo, Long idc) {
			super();
			this.idProd = idProd;
			this.designation = designation;
			this.prix = prix;
			this.photo = photo;
			this.categorie = categorie;
		}
		
		
///
		public Long getIdProd() {
			return idProd;
		}

		public void setIdProd(Long idProd) {
			this.idProd = idProd;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		//@JsonIgnore
		public Categorie getCategorie() {
			return categorie;
		}

	@JsonSetter
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	
	
		@Override
		public String toString() {
			return "Produit [idProd=" + idProd + ", designation=" + designation + ", prix=" + prix + ", photo=" + photo
					+ ", categorie=" + categorie + "]";
		}

		
		
		
		
		
		
		
		
}
	
	

