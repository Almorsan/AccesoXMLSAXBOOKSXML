
import java.io.File;


public class Main {

    
    public static void main(String[] args) {
        
        File f=new File("books.xml");
        AccesoXMLSAX a =new AccesoXMLSAX();
        a.parsearXMLconTitulosSAXhandler(f);
        a.parsearXMLconLibrosSAXhandler(f);
        
    }
    
}
