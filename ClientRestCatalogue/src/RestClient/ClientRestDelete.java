package RestClient;

import java.io.IOException;

import java.net.URISyntaxException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class ClientRestDelete {

	public static void main(String[] args) throws  IOException, URISyntaxException {
		
    //Delete Categorie
		
	/*	Long idd=1l;
	
			Client client =Client.create(new DefaultClientConfig());
		
	        WebResource webResource= client.resource("http://localhost:8009/RestCatalogueProduit/catalogue/categories/"+idd);
	        
	        ClientResponse resHttp = webResource.delete(ClientResponse.class);
	    
	    }
	*/
	
	//Delete produit
		
	Long idp=9l;
	
	Client client =Client.create(new DefaultClientConfig());

    WebResource webResource= client.resource("http://localhost:8009/RestCatalogueProduit/catalogue/produits/"+idp);
    
    ClientResponse resHttp = webResource.delete(ClientResponse.class);

}
	
}

