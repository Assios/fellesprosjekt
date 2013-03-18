package modelPakke;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;


import com.google.gson.Gson;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLReader {

    public static void main(String[] args) {
        Gson gson = new Gson();
        User u = new User();

        try {

        /*	XPathFactory xpathFactory = XPathFactory.newInstance();
        	XPath xpath = xpathFactory.newXPath();

        	InputSource source = new InputSource(new FileReader(
        			"c:/temp/data.txt"));
        	String status = xpath.evaluate("/name/email", source);
        	
            FileInputStream fis = new FileInputStream("c:/temp/data.txt");*/
            gson.toJson(u);
            
            //print the data from the object that has been read
            System.out.println(u.toString());
		
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
 

