package modelPakke;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLReader {

    public static void main(String[] args) {
        XStream xs = new XStream(new DomDriver());
        User u = new User();

        try {
            FileInputStream fis = new FileInputStream("c:/temp/data.txt");
            xs.fromXML(fis, u);

            //print the data from the object that has been read
            System.out.println(u.toString());

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
 

