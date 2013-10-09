package edu.sjsu.cmpe.project.dto;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import edu.sjsu.cmpe.project.connectiondao.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import edu.sjsu.cmpe.project.domain.User;

@JsonPropertyOrder(alphabetic = true)
public class UserDto extends LinksDto {
    private User user;


    public UserDto(User user) {
	super();
	this.user = user;
    }
    public UserDto() {

    }

    /**
     * @return the book
     */
    public User getUser() {
	return user;
    }


    public void setUser(User user) {
	this.user = user;
    }
    public void makeConnection() throws UnknownHostException
    {
    	DBConnection dbc=new DBConnection("user");
    	//return dbc.establishConnection();
    }

  public void createUser(User usr) throws UnknownHostException {
        DBConnection dbc=new DBConnection("user");
        //System.out.println("this is in UserDto");
        //System.out.println(this.user);
          dbc.StoreUser(usr);
    }
 /* public ArrayList<UserDto> getUsersListByDept(String department) throws UnknownHostException
     {
        DBConnection dbc=new DBConnection("user");
         ArrayList<UserDto> usersList= new ArrayList<UserDto>();
         usersList=dbc.usersInDepartment("department");
         usersList=dbc.coll.find("department");
         return usersList;
     }       */
}
