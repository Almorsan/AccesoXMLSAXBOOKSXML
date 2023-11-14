
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class TitulosSAXhandler extends DefaultHandler {

    private String etiqueta;

    public TitulosSAXhandler() {
        etiqueta = "";
    }
   
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
     
         if (etiqueta.equals("author")) {
            String titulo = new String(ch, start, length);
            titulo = titulo.replaceAll("[\t\n]", "").trim(); //.trim() elimina los espacios en blanco al principio y al final de una cadena
            if (!titulo.isEmpty()) {
                System.out.print(titulo + ", ");
            }
        } else if (etiqueta.equals("title")) {
            String autor = new String(ch, start, length);
            System.out.println(autor.trim());
        } 
        
        
        
       
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("book")) {
            etiqueta = "book";

        } else if (qName.equals("title")) {
            etiqueta = "title";
        } else if (qName.equals("author")) {
            etiqueta = "author";
        } else if (qName.equals("id")) {
            etiqueta = "id";
        } else if (qName.equals("genre")) {
            etiqueta = "genre";
        } else if (qName.equals("price")) {
            etiqueta = "price";
        } else if (qName.equals("publish_date")) {
            etiqueta = "publish_date";
        }  else if (qName.equals("description")) {
            etiqueta = "description";
        } 
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("LISTADO DE TITULOS");
        System.out.println("==================");
    }

}
