package modelPakke;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.thoughtworks.xstream.*;

public class XMLWriter {

	public static void main(String[] args) throws IOException {
		User u = new User();

		// Set the properties using the setter methods
		// Note: This can also be done with a constructor.
		// Since we want to show that XStream can serialize
		// even without a constructor, this approach is used.
		u.setName("Jack");
		u.setEmail("asgas");
		u.setDateOfBirth(new Date(1992, 03, 20));

		// Serialize the object
		XStream xs = new XStream();

		// Write to a file in the file system
		try {
			FileOutputStream fs = new FileOutputStream("c:/temp/data.txt");
			xs.toXML(u, fs);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
