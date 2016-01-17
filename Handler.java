package xml;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	private Map<Integer, String> data = new HashMap <Integer, String>();
	private int id;
	private String element;
	
	@Override
	public void startDocument() throws SAXException{
		System.out.println("Starting parcing.....");
	}
	
	@Override
	public void endDocument() throws SAXException{
		System.out.println("End parcing");
	}
	
	@Override
	public void startElement(String namespace, String localName, String qName, Attributes attr){
		element = qName;
		if(element.equals("computer")){
			id = Integer.parseInt(attr.getValue(0));
		}
	}
	
	@Override
	public void endElement(String namespace, String localName, String qName) throws SAXException {
		element = "";
		id = -1;
	}
	
	@Override
	public void characters(char []ch, int start, int end){
		if(element.equals("title")){
			String titleStr =new String(ch, start, end);
			data.put(id, titleStr);
		}
		
	}

	public Map<Integer, String> getData(){
		return data;
	}
}

