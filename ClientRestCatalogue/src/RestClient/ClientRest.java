package RestClient;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.WebResource;

import metier.Categorie;

public class ClientRest{

	public static void main(String[] args) throws  IOException {
		
		
		Client client =Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/").build();

		//Ajouter Categorie
		
		Categorie c2= new Categorie(8L,"catego8","8.jpg");
		
		ObjectMapper mapper = new ObjectMapper();

		 ClientResponse reponse2=client.resource(uri)
				 			.path("catalogue")
				 			.path("categories")
				 			.type(MediaType.APPLICATION_JSON)
				 			.post(ClientResponse.class,mapper.writeValueAsString(c2));
		System.out.println(reponse2.getEntity(String.class));
		
		//Consulter les catégories
		
		ClientResponse response = client.resource(uri)
				.path("catalogue")
				.path("categories")
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		String corpsRepHttp=response.getEntity(String.class);
		
		System.out.println(corpsRepHttp);
		
		
		Categorie[] cats = mapper.readValue(corpsRepHttp, Categorie[].class);
		
		for(Categorie c:cats)
		{
			System.out.println(c.getIdCat());
			System.out.println(c.getNom());
			System.out.println(c.getPhoto());
			System.out.println("--------------");
			
		}
		
		
		//Modifier Categorie 
		
		Categorie c3= new Categorie(1L,"CatMODIF","8.jpg");
		c3.setNom("hello");
		
		//ObjectMapper mapper = new ObjectMapper();

		 ClientResponse reponseUpdate;

		 reponseUpdate = client.resource(uri)
					 			.path("catalogue")
					 			.path("categories")
					 			.type(MediaType.APPLICATION_JSON)
					 			.put(ClientResponse.class,mapper.writeValueAsString(c3));
					 			
		
		System.out.println(reponseUpdate.getEntity(String.class));
		
		
		
}
}
