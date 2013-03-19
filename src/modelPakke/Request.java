package modelPakke;

public class Request implements java.io.Serializable {
  String userName,password;
	Object object;
	String type;
	
	public Request(String t,String uN, String password, Object o) {
		this.type=t;
		this.userName=uN;
		this.password=password;
		object=o;
		
	}
	
	public String getType(){
		return type;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassword(){
		return password;
	}
}
