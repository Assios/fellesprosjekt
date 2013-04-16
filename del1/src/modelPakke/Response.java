package modelPakke;

import java.util.ArrayList;
import java.util.Collection;

public class Response implements java.io.Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = -6032594500555781432L;
	User u;
	ArrayList<Meeting> meetings;
	ArrayList<User> users;
	String result;
	
	
	public Response(ArrayList<User> users,String result){
		this.users=users;
		this.result=result;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public String getResult(){
		return result;
	}
}
