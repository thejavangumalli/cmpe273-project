package edu.sjsu.cmpe.project.api.resources;

import edu.sjsu.cmpe.project.domain.User;
import edu.sjsu.cmpe.project.dto.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.UnknownHostException;
import java.util.ArrayList;


@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    public UserResource() 
    {
	// do nothing
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto addUser(@FormParam("firstname") String firstname,
    		@FormParam("lastname") String lastname) throws UnknownHostException 
    {
    	User request=new User();
    	request.setFirstName(firstname);
    	request.setLastName(lastname);
        UserDto ud=new UserDto();
        ud.makeConnection();
        ud.createUser(request);
        return ud;
        
        
        //String json = "{'id' :"+request.getId()+",'firstName':"+request.getFirstName()+"}";
        // String json="{'id' : '1','firstName' : 'santu'}}";
        //DBObject dbObject = (DBObject)JSON.parse(json);

        //collection.insert(dbObject);
        //request.setId(1);
        //ud.setUser(user);
        //DBConnection db=new DBConnection("user");
       
        //System.out.println(request.geteMail());
        //System.out.println("UD");
        //System.out.println(ud);
         //db.StoreUser(request);
        /*MongoClient mc=new MongoClient(new ServerAddress("localhost",27017));
        DB database=mc.getDB("test");
        DBCollection coll=database.getCollection("user");
       // coll.insert((DBObject) request);
        BasicDBObject document = new BasicDBObject();
        document.put("id", "1");
        document.put("firstName", "king");

       // document.put("detail", document);
       coll.insert(document);
           */

        //coll.insert(document);
        
    }

   
        
   }


