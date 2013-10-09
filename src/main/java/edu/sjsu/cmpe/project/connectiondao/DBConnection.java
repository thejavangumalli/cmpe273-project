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
     public ArrayList<UserDto> usersInDepartment(String dept)
    {
        //BasicQuery query1 = new BasicQuery("{ age : { $lt : 40 }, name : 'cat' }");
        //User userTest1 = coll.find(query1, User.class);
        //BasicQuery query1=new BasicQuery("{department:'electronics'}");

        ArrayList<UserDto> usrDt=new ArrayList<UserDto>();
        //usrDt.addAll(coll.findOne(query1,User.class));
        coll.findOne();
        BasicDBObject document = new BasicDBObject();
        document.containsValue(dept);
       document.
        //DBObject document = new DBObject();
       //DBObject cursor= coll.find({"department":dept});
        //Cursor myCourser=new Cursor();
      //var myCursor = coll.find("department";:document);
        return (ArrayList<UserDto>)coll.findOne();
    }
    //public List<BasicDBObject>
}
