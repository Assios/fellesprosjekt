package modelPakke;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.google.gson.Gson;
import com.thoughtworks.xstream.*;

public class XMLWriter {

    public static void main(String[] args) {
        User u = new User();
        User u2=new User();

        //Set the properties using the setter methods
        //Note: This can also be done with a constructor.
        //Since we want to show that XStream can serialize
        //even without a constructor, this approach is used.
        u.setName("Jack");
        u.setEmail("asgas");
        u.setDateOfBirth(new Date(1992,03,20));
        
        u2.setName("Steve");
        u2.setEmail("hsdhsdfh");
        u.setDateOfBirth(new Date(1992,03,21));
        

        //Serialize the object
		Gson gson = new Gson();
		User user = new User("John Doe", "john@gmail.com", new Date(1992, 23, 05));
		
		//Konverterer fra Javaobjekt til JSON.
		String json = gson.toJson(user);
        
        System.out.println();
        gson.toJson(u);
		gson.toJson(u2);
    }
}


