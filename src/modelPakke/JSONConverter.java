package modelPakke;

import java.util.Date;

import com.google.gson.Gson;

public class JSONConverter {

	public static void main(String[] args) {
		Gson gson = new Gson();
		User user = new User("John Doe", "john@gmail.com", new Date(1992, 23, 05));
		
		//Konverterer fra Javaobjekt til JSON.
		String json = gson.toJson(user);
		System.out.println(json);

	}

}
