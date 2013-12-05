package edu.sjsu.cmpe.project.ui.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe.project.ui.views.HomeView;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {


    public HomeResource() {
	 
    }

    @GET
    public HomeView getHome() {
        return new HomeView();
    }
}
