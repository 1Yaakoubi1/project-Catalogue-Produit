package controlleurs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;


import modele.entities.Categorie;
import modele.entities.Produit;

/**
 * Servlet implementation class servletProduit
 */
@WebServlet({"/servletProduit","/listerProduits","/AjoutP","/delete/{idp}","/UpdateP","/editP","/rechercheP/{idp}","/rechercheMC","/listerProduitsParCat"})

public class servletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String path = request.getServletPath();
		
		if(path.equals("/listerProduits")) {
			
			Client client = Client.create(new DefaultClientConfig());
			URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
			ClientResponse responseclient = client.resource(uri).path("allproduits").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			String httpresponse = responseclient.getEntity(String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			
			ArrayList<Produit> lstprod = new ArrayList<Produit>();
			try {
				Produit[] produit = mapper.readValue(httpresponse, Produit[].class);
				for(Produit p : produit) {
					p.getIdProd();
					p.getDesignation();
					p.getPrix();
					p.getPhoto();
					p.getCategorie().getIdCat();
					lstprod.add(p);
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
				request.setAttribute("lstprod", lstprod);
				request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
			}
		

		
		
if (path.equals("/delete/{idp}")) {
	 
	Long idp = Long.parseLong(request.getParameter("idp"));
 
	
	Client client =Client.create(new DefaultClientConfig());

 WebResource webResource= client.resource("http://localhost:8009/RestCatalogueProduit/catalogue/produits/"+idp);
 
 ClientResponse resHttp = webResource.delete(ClientResponse.class);

request.getRequestDispatcher("/GestionProduit.jsp").forward(request, response);

}	

if(path.equals("/UpdateP")) {
	 
	 
	 Long idp = Long.parseLong(request.getParameter("IdP"));
		String designation = request.getParameter("designationP");
		double prix = Double.valueOf(request.getParameter("prixP"));
		String photo = request.getParameter("photoP");
		Long idcategorie = Long.parseLong (request.getParameter("idcategorie"));
		
		Produit p = new Produit();
		Categorie c = new Categorie();
		c.setIdCat(idcategorie);
		
		p.setIdProd(idp);
		p.setDesignation(designation);
		p.setPrix(prix);
		p.setPhoto(photo);
		p.setCategorie(c);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		Client client =Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/").build();
		
		ClientResponse reponse2=client.resource(uri)
					 			.path("catalogue")
					 			.path("produits")
					 			.type(MediaType.APPLICATION_JSON)
					 			.put(ClientResponse.class,mapper.writeValueAsString(p));
		
		
		request.setAttribute("p", p);
	
		request.getRequestDispatcher("/UpdateProduit.jsp").forward(request,response);
		}

if(path.equals("/editP")) {
		
		Long id = Long.parseLong(request.getParameter("IdP"));
		
		Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		ClientResponse responseclient1 = client.resource(uri).path("/produits/"+id).type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		String httpresponse = responseclient1.getEntity(String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Produit p = mapper.readValue(httpresponse, Produit.class);
		
		request.setAttribute("p", p);
		request.getRequestDispatcher("/UpdateProduit.jsp").forward(request, response);
		}
	
	
if(path.equals("/rechercheP/{idp}")) {
	
	
	Long idp = Long.parseLong(request.getParameter("idp"));
	
	Client client = Client.create(new DefaultClientConfig());
	URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
	ClientResponse responseclient1 = client.resource(uri).path("/produits/"+idp).type(MediaType.APPLICATION_JSON)
			.get(ClientResponse.class);
	
	String httpresponse = responseclient1.getEntity(String.class);
	
	ObjectMapper mapper = new ObjectMapper();
	ArrayList<Produit> lstprod = new ArrayList<Produit>();
	try {

		Produit p = mapper.readValue(httpresponse, Produit.class);
		 
		lstprod.add(p);
	
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
	request.setAttribute("lstprod", lstprod);
	
	request.getRequestDispatcher("/GestionProduit.jsp").forward(request, response);
	}

if(path.equals("/listerProduitsParCat")) {
	
	Long idRC = Long.parseLong(request.getParameter("idRC"));
	

	Client client = Client.create(new DefaultClientConfig());
	URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
	ClientResponse responseclient = client.resource(uri)
											.path("categories/"+idRC)
											.path("/produits")
											.type(MediaType.APPLICATION_JSON)
											.get(ClientResponse.class);
	String httpresponse = responseclient.getEntity(String.class);
	
	ObjectMapper mapper = new ObjectMapper();
	
	ArrayList<Produit> lstprod = new ArrayList<Produit>();
	try {
		Produit[] produit = mapper.readValue(httpresponse, Produit[].class);
		
		for(Produit p : produit) {
			p.getIdProd();
			p.getDesignation();
			p.getPrix();
			p.getPhoto();
			p.getCategorie().getIdCat();
			lstprod.add(p);
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
		request.setAttribute("lstprod", lstprod);
		request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
	}











if(path.equals("/rechercheMC")) {


String mcp = request.getParameter("mc");

Client client = Client.create(new DefaultClientConfig());
URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();

ClientResponse responseclient = client.resource(uri)
										.path("MCproduits/"+mcp)
										.type(MediaType.APPLICATION_JSON)
										.get(ClientResponse.class);

String httpresponse = responseclient.getEntity(String.class);

ObjectMapper mapper = new ObjectMapper();

ArrayList<Produit> lstprod = new ArrayList<Produit>();
try {
	Produit[] produit = mapper.readValue(httpresponse, Produit[].class);
	
	for(Produit p : produit) {
		p.getIdProd();
		p.getDesignation();
		p.getPrix();
		p.getPhoto();
		p.getCategorie().getIdCat();
		lstprod.add(p);
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
	request.setAttribute("lstprod", lstprod);
	request.getRequestDispatcher("GestionProduit.jsp").forward(request, response);
}







if(path.equals("/AjoutP")) {
	
	Long idp = Long.parseLong(request.getParameter("IdP"));
	String designation = request.getParameter("designationP");
	double prix = Double.valueOf(request.getParameter("prixP"));
	String photo = request.getParameter("photoP");
	Long idcategorie = Long.parseLong (request.getParameter("idcategorie"));
	
	
	Produit p = new Produit();
	Categorie c = new Categorie();
	c.setIdCat(idcategorie);
	
	p.setIdProd(idp);
	p.setDesignation(designation);
	p.setPrix(prix);
	p.setPhoto(photo);
	p.setCategorie(c);
	
	
	ObjectMapper mapper = new ObjectMapper();
	Client client = Client.create(new DefaultClientConfig());
	URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
	
	
	ClientResponse responseclient = client.resource(uri).path("produits").type(MediaType.APPLICATION_JSON)
			.post(ClientResponse.class,mapper.writeValueAsString(p));
	
	response.sendRedirect("./GestionProduit.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
