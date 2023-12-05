
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class LibrosSAXhandler extends DefaultHandler {

    int contador = 0;

    public LibrosSAXhandler() {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
         //este método únicamente imprime información general sobre un libro: aquí todavía
         //no podemos saber el título o el autor de un libro en particular
        if (qName.equals("book")) { //si el nodo es book, se incrementa el contador
            contador++;
            System.out.println("Libro nº: " + contador + "\n");
            System.out.println("Id: " + atts.getValue(atts.getQName(0))); //extrae el primer atributo
        } else if (qName.equals("author")) {
            System.out.print("\n " + "El autor es: ");//aún no sabemos cúal es el título, eso lo sabremos en el evento characters

        } else if (qName.equals("title")) {
            System.out.print("\n " + "El título es: ");
        } else if (qName.equals("genre")) {
            System.out.print("\n " + "El género es: ");
        } else if (qName.equals("price")) {
            System.out.print("\n " + "El precio es: ");
        } else if (qName.equals("publish_date")) {
            System.out.print("\n " + "La fecha de publicación es: ");
        } else if (qName.equals("description")) {
            System.out.print("\n " + "La descripción es: ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //este método separa cada uno de los libros mediante una barra (------------)
        if (qName.equals("book")) {
            System.out.println("\n-----------------------");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //con este método, mostramos la distinta información del libro
        //además, suprime caracteres sobrantes como los tabuladores
        String car = new String(ch, start, length);
        car = car.replaceAll("\t", "");//quita todos los tabuladores
        car = car.replaceAll("\n", "");
        System.out.println(car); //car es la información de un libro que queremos mostrar en ese momento
        //(autor,título...)
    }

}
