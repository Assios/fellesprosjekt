package modelPakke;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.google.gson.Gson;
import com.thoughtworks.xstream.*;

public class JSONWriter {

    public static void main(String[] args) {
        User u = new User();
        User u2=new User();

        //Set the properties using the setter methods
        //Note: This can also be done with a constructor.
        //Since we want to show that XStream can serialize
        //even without a constructor, this approach is used.
        u.setName("Jack", "Thompson");
        u.setEmail("asgas@gmail.com");
        u.setDateOfBirth(new Date(1992,03,20));
        
        u2.setName("Steve", "Johnson");
        u2.setEmail("hsdhsdfh@hotmail.net");
        u.setDateOfBirth(new Date(1992,03,21));
        

        //Serialize the object
		Gson gson = new Gson();
		User user = new User("Brukernavn","Fornavn","Etternavn", "Epost", new Date(22,22,22));
		
		//Konverterer fra Javaobjekt til JSON.
		String json = gson.toJson(user);
        
        System.out.println();
        gson.toJson(u);
		gson.toJson(u2);
    }
}


