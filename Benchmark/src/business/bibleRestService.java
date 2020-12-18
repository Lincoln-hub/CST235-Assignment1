package business;





import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Scripture;



@RequestScoped
@Path("/Scripture")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class bibleRestService {
	
	
	@Inject
	bibleBusinessInterface service;
	
	
	
		@GET
		@Path("/getjson")
		@Produces(MediaType.APPLICATION_JSON)
		public String getVerseAsJson(Scripture script)
		{
			return service.returnVerse(script);
			
		}

}
