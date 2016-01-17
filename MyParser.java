package xml;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyParser extends DefaultHandler{
	
	public static void main(String []Args){
	SAXParserFactory parserF = SAXParserFactory.newInstance();
	Handler handler = new Handler();
	try{
		SAXParser saxparser = parserF.newSAXParser();
		saxparser.parse(new File("f:\\Обучение\\Java\\xml\\src\\xml\\computerStore.xml"), handler);
	} catch(ParserConfigurationException | SAXException e){
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}
	
	Map<Integer,String> data = handler.getData();
	for (Map.Entry<Integer,String> dMap: data.entrySet() ) {
		System.out.println(" id: " + dMap.getKey() + " - title: " + dMap.getValue());
	}
}}

