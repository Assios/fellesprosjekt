package modelPakke;

import java.util.Date;

import com.google.gson.Gson;

public class JSONConverter {

	public static void main(String[] args) {
		Gson gson = new Gson();
		User user = new User("Brukernavn","Fornavn","Etternavn", "Epost", new Date(22,22,22));
		
		//Konverterer fra Javaobjekt til JSON.
		String json = gson.toJson(user);
		System.out.println(json);

	}

}
