
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
        //con este m�todo, mostramos el autor y t�tulo de un libro
     
         if (etiqueta.equals("author")) {
            String titulo = new String(ch, start, length);
            titulo = titulo.replaceAll("[\t\n]", "").trim(); //.trim() elimina los espacios en blanco al principio y al final de una cadena
            if (!titulo.isEmpty()) { //si el t�tulo no est� vac�o
                System.out.print(titulo + ", "); //mostramos el autor y una coma
            }
        } else if (etiqueta.equals("title")) {
            String autor = new String(ch, start, length);
            System.out.println(autor.trim()); //mostramos el t�tulo
        } 
        
        
        
       
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //con este m�todo manejamos el valor del atributo global etiqueta en relaci�n al valor del 
        //atributo pasado por par�metro qName (ambos String)
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
        //este m�todo muestra el encabezado de la lista de t�tulos
        System.out.println("LISTADO DE TITULOS");
        System.out.println("==================");
    }

}
