/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domwriter;

import java.io.File;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Diego
 */
public class DomWriter {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("usuario");
            doc.appendChild(rootElement);
            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("nombre"));
            rootElement.appendChild(nombre);
            
            
            Element apellido = doc.createElement("apellido");
            apellido.appendChild(doc.createTextNode("apellido"));
            rootElement.appendChild(apellido);
            
            
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            URL url = DomWriter.class.getResource("test.xml");
            File file = new File(url.getPath());
            StreamResult result = new StreamResult(file);
            
            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            
            transformer.transform(source, result);
            
            System.out.println("File saved!");
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
