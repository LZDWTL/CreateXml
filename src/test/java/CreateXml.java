import junit.framework.TestSuite;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author 10237
 * @date 2021-03-14 15:28
 */

public class CreateXml extends TestSuite {

    @Test
    public void testCreateXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;

        {
            try {
                documentBuilder = factory.newDocumentBuilder();
                Document doc = documentBuilder.newDocument();
                Element root = doc.createElement("Students");
                Element stu = doc.createElement("cn.bean.Student");
                Element name = doc.createElement("name");
                Element address = doc.createElement("adderss");

                doc.appendChild(root);
                root.appendChild(stu);
                stu.appendChild(name);
                stu.appendChild(address);

                name.appendChild(doc.createTextNode("陈可可"));
                name.setAttribute("身高", "165");
                address.appendChild(doc.createTextNode("广西桂林"));
                address.setAttribute("中国", "YES");

                //写入xml
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("D:\\缓存\\cn.bean.Student.xml"));

                transformer.transform(source, result);
                System.out.println("File Saved!");

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testM(){
        System.out.println("holle");
        assert(1==2);
    }
}
