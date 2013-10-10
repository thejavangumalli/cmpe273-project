package edu.sjsu.cmpe.project.connectiondao;
import java.awt.*;
import java.net.SocketPermission;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.*;
import edu.sjsu.cmpe.project.domain.User;
import edu.sjsu.cmpe.project.dto.UserDto;

public class DBConnection {

    MongoClient mc;
    DB database;
    DBCollection coll;
    //String collectionTable;


    public DBConnection(String collectionTable) throws UnknownHostException {

        mc = new MongoClient(new ServerAddress("localhost",27017));
        database=mc.getDB("test");
        coll=database.getCollection(collectionTable);
       System.out.println(collectionTable);
    }

	/*public String establishConnection() throws UnknownHostException
	{
		try
		{
		MongoClient mc=new MongoClient(new ServerAddress("localhost",27017));
		DB database=mc.getDB("test");
		DBCollection coll=database.getCollection("mycollection");
		coll.findOne();
		return coll.findOne().toString();
		}
		catch(UnknownHostException ex)
		{
		 return ex.toString();
		}
		//return "Successful";
	}      */
    public void StoreUser(User request){
        //coll.insert(userDetails);
        BasicDBObject document = new BasicDBObject();
        document.put("id", request.getId());
        document.put("firstName", request.getFirstName());
        document.put("lastName", request.getLastName());
        document.put("eMail", request.geteMail());
        document.put("phoneNumber", request.getPhoneNumber());
        coll.insert(document);
        //coll.save((DBObject)userDetails) ;
    }
   /* public ArrayList<UserDto> usersInDepartment(String dept)
    {

        //DBObject document = new DBObject();
       DBObject cursor= coll.find({"department":dept});
        //Cursor myCourser=new Cursor();
      //var myCursor = coll.find("department";:document);
        return null;
    }        */
    //public List<BasicDBObject>
}
