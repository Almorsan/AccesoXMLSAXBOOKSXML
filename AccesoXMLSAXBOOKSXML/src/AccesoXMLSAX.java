
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AccesoXMLSAX {

    SAXParser parser;

    public int parsearXMLconLibrosSAXhandler(File f) {
        //con este método parseamos un archivo xml a sax mediante
        //un objeto de tipo file pasado por parámetro y obtenemos la lista de libros con
        //sus elementos (titulo, autor, fecha publicación...)
        //utilizamos las clases SAXParser, SAXParserFactory y
        //LibrosSAXhandler, la cual hemos configurado en este proyecto

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            LibrosSAXhandler sh = new LibrosSAXhandler();
            parser.parse(f, sh);
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;

        }

    }

    public int parsearXMLconTitulosSAXhandler(File f) {
        //con este método parseamos un archivo xml a sax mediante
        //un objeto de tipo file pasado por parámetro y obtenemos 
        //una lista de títulos.
        //utilizamos las clases SAXParser, SAXParserFactory y
        //TitulosSAXhandler, la cual hemos configurado en este proyecto
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            TitulosSAXhandler sh = new TitulosSAXhandler();
            parser.parse(f, sh);
            return 0;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
