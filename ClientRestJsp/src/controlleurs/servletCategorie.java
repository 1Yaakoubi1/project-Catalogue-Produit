package controlleurs;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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



/**
 * Servlet implementation class servletCategorie
 */
@WebServlet({"/servletCategorie","/listerCategories","/Ajout","/recherche/{idc}","/delete/{idd}","/Update","/edit/{idc}","/edit"})
public class servletCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		if(path.equals("/listerCategories")) {
			
			Client client = Client.create(new DefaultClientConfig());
			URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
			ClientResponse responseclient = client.resource(uri).path("categories").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			String httpresponse = responseclient.getEntity(String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			
			ArrayList<Categorie> lstcat = new ArrayList<Categorie>();
			try {
				Categorie[] categorie = mapper.readValue(httpresponse, Categorie[].class);
				for(Categorie c : categorie) {
					c.getIdCat();
					c.getNom();
					c.getPhoto();
					lstcat.add(c);
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
				request.setAttribute("lstcat", lstcat);
				request.getRequestDispatcher("GestionCategorie.jsp").forward(request, response);
			}
		
if(path.equals("/Ajout")) {
			
			Long idc = Long.parseLong(request.getParameter("IdC"));
			
			String nom = request.getParameter("nomC");
			String photo = request.getParameter("photoC");
			Categorie cat = new Categorie(idc,nom,photo);
			
			
			ObjectMapper mapper = new ObjectMapper();
			Client client = Client.create(new DefaultClientConfig());
			URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
			
			
			ClientResponse responseclient = client.resource(uri).path("categories").type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class,mapper.writeValueAsString(cat));
			
			response.sendRedirect("./GestionCategorie.jsp");
			}

 if(path.equals("/recherche/{idc}")) {
	
	
	Long idc = Long.parseLong(request.getParameter("idc"));
	
	Client client = Client.create(new DefaultClientConfig());
	URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
	ClientResponse responseclient1 = client.resource(uri).path("/categories/"+idc).type(MediaType.APPLICATION_JSON)
			.get(ClientResponse.class);
	
	String httpresponse = responseclient1.getEntity(String.class);
	
	ObjectMapper mapper = new ObjectMapper();
	ArrayList<Categorie> lstcat = new ArrayList<Categorie>();
	try {

		Categorie c = mapper.readValue(httpresponse, Categorie.class);
		 
			lstcat.add(c);
	
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
	request.setAttribute("lstcat", lstcat);
	
	request.getRequestDispatcher("/GestionCategorie.jsp").forward(request, response);
	}
 
 
 
 if (path.equals("/delete/{idd}")) {
	 
		Long idd = Long.parseLong(request.getParameter("idd"));
	 
		
		Client client =Client.create(new DefaultClientConfig());
	
     WebResource webResource= client.resource("http://localhost:8009/RestCatalogueProduit/catalogue/categories/"+idd);
     
     ClientResponse resHttp = webResource.delete(ClientResponse.class);
    
    // response.sendRedirect("list");
    request.getRequestDispatcher("/GestionCategorie.jsp").forward(request, response);
    //request.getRequestDispatcher("list").forward(request, response);
     
     
		
 }
 
 if(path.equals("/Update")) {
	 
	 
	 	Long idc = Long.parseLong(request.getParameter("IdC"));
		String nom = request.getParameter("nomC");
		String photo = request.getParameter("photoC");
		
		Categorie c = new Categorie(idc,nom,photo);
		ObjectMapper mapper = new ObjectMapper();
		
		Client client =Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/").build();
		
		ClientResponse reponse2=client.resource(uri)
					 			.path("catalogue")
					 			.path("categories")
					 			.type(MediaType.APPLICATION_JSON)
					 			.put(ClientResponse.class,mapper.writeValueAsString(c));
		
		
		request.setAttribute("c", c);
	
		request.getRequestDispatcher("/UpdateCategorie.jsp").forward(request,response);
		}
 
 if(path.equals("/edit")) {
		
		Long id = Long.parseLong(request.getParameter("IdC"));
		
		Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		ClientResponse responseclient1 = client.resource(uri).path("/categories/"+id).type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		String httpresponse = responseclient1.getEntity(String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Categorie c = mapper.readValue(httpresponse, Categorie.class);
		
		request.setAttribute("c", c);
		request.getRequestDispatcher("/UpdateCategorie.jsp").forward(request, response);
		}
 	
	}
	
	private void listCategorie( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		Client client = Client.create(new DefaultClientConfig());
		URI uri = UriBuilder.fromUri("http://localhost:8009/RestCatalogueProduit/catalogue/").build();
		ClientResponse responseclient = client.resource(uri).path("categories").type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		String httpresponse = responseclient.getEntity(String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Categorie> lstcat = new ArrayList<Categorie>();
		try {
			Categorie[] categorie = mapper.readValue(httpresponse, Categorie[].class);
			for(Categorie c : categorie) {
				c.getIdCat();
				c.getNom();
				c.getPhoto();
				lstcat.add(c);
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
			request.setAttribute("lstcat", lstcat);
			request.getRequestDispatcher("GestionCategorie.jsp").forward(request, response);
		
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
