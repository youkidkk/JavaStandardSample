package xml.sample;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import java.io.InputStream;

@SuppressWarnings("javadoc")
public class XmlSample {

    public static void main(String[] args) throws Exception {
        try (InputStream is = ClassLoader.getSystemResourceAsStream("sample.xml")) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);

            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList list = (NodeList) xpath.evaluate("/root/sampleA", doc,
                    XPathConstants.NODESET);
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                NodeList list2 = (NodeList) xpath.evaluate("sampleB", node,
                        XPathConstants.NODESET);
                for (int i2 = 0; i2 < list2.getLength(); i2++) {
                    System.out.println(list2.item(i2).getTextContent());
                }
            }
        }
    }

}
