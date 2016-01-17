package xml;

import java.io.FileReader;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class MyParser extends DefaultHandler{
	String result = "";
	
		public static void main (String args[])throws Exception {
		
		XMLReader xr = XMLReaderFactory.createXMLReader();
		MyParser handler = new MyParser();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
		
	    FileReader r = new FileReader("f:\\Обучение\\Java\\xml\\computerStore.xml");
	    xr.parse(new InputSource(r));

	}
	
	public MyParser() {
		super();
	}
	
	public void startDocument ()
	{
	System.out.println("Start document");
	}
	 
	public void endDocument ()
	{
	System.out.println("End document");
	}


	public void startElement (String uri, String name, String qName, Attributes atts){
		//System.out.println(qName) ;
		for (int att = 0; att < atts.getLength(); att++) {
		      String attName = atts.getQName(att);
		      System.out.println(" " + attName + ": " + atts.getValue(attName));
		    }
	  }
	
	
}

