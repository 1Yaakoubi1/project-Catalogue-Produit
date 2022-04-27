package RestClient;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import metier.Categorie;
import metier.Produit;

public class RestClientProduit {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, UniformInterfaceException, ClientHandlerException, IOException {
		
		
//*********************************LISTER LES PRODUITS*******************************************************************
		
		/*Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		ClientResponse responseclient = client.resource(uri).path("allproduits").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String httpresponse = responseclient.getEntity(String.class);
		
		
		
		System.out.println(httpresponse);
		ObjectMapper mapper = new ObjectMapper();
		
		Produit[] prods = null;
		try {
			prods = mapper.readValue(httpresponse, Produit[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Produit p:prods)
		{
			System.out.println(p.getIdProd());
			System.out.println(p.getDesignation());
			System.out.println(p.getPhoto());
			System.out.println(p.getCategorie().getIdCat());
			System.out.println(p.getPhoto());
			System.out.println("--------------");
			
		}*/
		
//******************************************Recherche par mot cle******************************************************
		
	/*	String mcp = "png";
		
		Client client2 = Client.create(new DefaultClientConfig());
		URI uri2 = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		ClientResponse responseclient = client2.resource(uri2)
												.path("MCproduits/"+mcp)
												.type(MediaType.APPLICATION_JSON)
												.get(ClientResponse.class);
		String httpresponse2 = responseclient.getEntity(String.class);
		
		System.out.println(httpresponse2);
		
		System.out.println("--------------");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Produit> lstprod = new ArrayList<Produit>();
		
		
		
		try {
			Produit[] produit = mapper.readValue(httpresponse2, Produit[].class);
			for(Produit p : produit) {
				System.out.println	(p.getIdProd());
				System.out.println(p.getDesignation());
				System.out.println(p.getPrix());
				System.out.println(p.getPhoto());
				System.out.println(p.getCategorie().getIdCat());
				lstprod.add(p);
				
			
				System.out.println("--------------");
				
			}
			
			
			}catch (JsonParseException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
		
		
//***************************RECH par ID *****************************************************************************************
	
	//http://localhost:8009/RestCatalogueProduit/catalogue/categories/1/produits
		
	/*	Long idC =1l;
		
		
		Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		ClientResponse responseclient = client.resource(uri)
												.path("categories/"+idC)
												.path("/produits")
												.type(MediaType.APPLICATION_JSON)
												.get(ClientResponse.class);
		String httpresponse = responseclient.getEntity(String.class);
		
		System.out.println(httpresponse);
		
		System.out.println("--------------");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Produit> lstprod = new ArrayList<Produit>();
		
		
		
		try {
			Produit[] produit = mapper.readValue(httpresponse, Produit[].class);
			for(Produit p : produit) {
				System.out.println	(p.getIdProd());
				System.out.println(p.getDesignation());
				System.out.println(p.getPrix());
				System.out.println(p.getPhoto());
				System.out.println(p.getCategorie().getIdCat());
				lstprod.add(p);
				
			
				System.out.println("--------------");
				
			}
			
			
			}catch (JsonParseException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	*/	
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//AJOUTER UN PRODUIT 
		/*

		Produit p = new Produit();
		Categorie c = new Categorie();
		c.setIdCat(3l);
		
		p.setIdProd(13l);
		p.setDesignation("livre13");
		p.setPrix(60);
		p.setPhoto("livre13.png");
		p.setCategorie(c);
		
		Produit p2 = new Produit(13l,"livre13",60,"livre.png",c.getIdCat());
		
		Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		
		
		ClientResponse responseclient = client.resource(uri).path("produits").type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,mapper.writeValueAsString(p2));
		
		System.out.println(responseclient.getEntity(String.class));
	*/
		

	}
}


