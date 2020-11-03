import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

    public class DomParserMPJYO8 {

        public static void main(String[] args) {

            try {
                File inputFile = new File("student.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse("student.xml");
                doc.getDocumentElement().normalize();
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("student");
                System.out.println("----------------------------");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("Student roll no : "
                                + eElement.getAttribute("rollno"));
                        System.out.println("First Name : "
                                + eElement
                                .getElementsByTagName("firstname")
                                .item(0)
                                .getTextContent());
                        System.out.println("Last Name : "
                                + eElement
                                .getElementsByTagName("lastname")
                                .item(0)
                                .getTextContent());
                        System.out.println("Nick Name : "
                                + eElement
                                .getElementsByTagName("nickname")
                                .item(0)
                                .getTextContent());
                        System.out.println("Age : "
                                + eElement
                                .getElementsByTagName("age")
                                .item(0)
                                .getTextContent());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

