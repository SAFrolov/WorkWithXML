/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busawithinterface;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author s.frolov
 */
public class WorkWithXML {

    public static void PrintAllFile(String url) {           
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
            
            Element root = doc.getDocumentElement(); //корневой элемент
            
            NodeList books = root.getChildNodes();

            
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                    if (book.getNodeType() != Node.TEXT_NODE) {
                        NodeList bookProps = book.getChildNodes();
                        Books newBook = new Books();
                            for (int j = 0; j < bookProps.getLength(); j++) {
                                Node bookProp = bookProps.item(j);
                                if(bookProp.getNodeType() != Node.TEXT_NODE){  
                                newBook.PrintFile(bookProp.getNodeName(),bookProp.getChildNodes().item(0).getTextContent());
                            }
                        }
                            newBook.addToList();
                            //BusaWithInterface.oBooks.add(newBook);
                }
            } 
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void AddInformation(String url, String author, String title, String genre, String price, String publish_date, String description)  {  
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);
            
            Node root = doc.getDocumentElement();
            
            Element book = doc.createElement("book");
            Element auth = doc.createElement("author");
            auth.setTextContent(author);
            Element titl = doc.createElement("title");
            titl.setTextContent(title);
            Element genr = doc.createElement("genre");
            genr.setTextContent(genre);
            Element pric = doc.createElement("price");
            pric.setTextContent(price);
            Element pub_date = doc.createElement("publish_date");
            pub_date.setTextContent(publish_date);
            Element discr = doc.createElement("description");
            discr.setTextContent(description);
            
            book.appendChild(auth);
            book.appendChild(titl);
            book.appendChild(genr);
            book.appendChild(pric);
            book.appendChild(pub_date);
            book.appendChild(discr);
            
            root.appendChild(book);
            
            writeDocument(url,doc);
            
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    private static void writeDocument(String url, Document doc){
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            FileOutputStream fos = new FileOutputStream(url);
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(WorkWithXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkWithXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(WorkWithXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public static void FindInformation(String url, String findSth) {           
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(url);           
            Element root = doc.getDocumentElement(); //корневой элемент            
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                    if (book.getNodeType() != Node.TEXT_NODE) {
                        NodeList bookProps = book.getChildNodes();
                        Books newBook = new Books();
                            for (int j = 0; j < bookProps.getLength(); j++) {
                                Node bookProp = bookProps.item(j);
                                if(bookProp.getNodeType() != Node.TEXT_NODE){  
                                newBook.PrintFile(bookProp.getNodeName(),bookProp.getChildNodes().item(0).getTextContent());
                            }
                        }
                            newBook.chackFind(findSth);
                            newBook.addToList();
                }
            } 
        } catch (SAXException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
