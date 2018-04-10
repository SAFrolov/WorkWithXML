/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busawithinterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author s.frolov
 */
public class BusaViewController implements Initializable {
    @FXML private TextField findSth;
    @FXML private TextField authorFind;
    @FXML private TextField nameFind;
    @FXML private TextField typeFind;
    @FXML private TextField priceFind;
    @FXML private TextField dateFind;
    @FXML private TextField discrFind;

    @FXML private TableView<Books> tableUsers;
    @FXML private TableColumn<Books, String> authorCol;
    @FXML private TableColumn<Books, String> nameCol;
    @FXML private TableColumn<Books, String> typeCol;
    @FXML private TableColumn<Books, String> priceCol;
    @FXML private TableColumn<Books, String> dateCol;
    @FXML private TableColumn<Books, String> discrCol;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        authorCol.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));        
        nameCol.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));        
        typeCol.setCellValueFactory(new PropertyValueFactory<Books, String>("genre"));        
        priceCol.setCellValueFactory(new PropertyValueFactory<Books, String>("price"));        
        dateCol.setCellValueFactory(new PropertyValueFactory<Books, String>("publish_date"));        
        discrCol.setCellValueFactory(new PropertyValueFactory<Books, String>("description"));
        //tableUsers.setItems(BusaWithInterface.oBooks);
    }    
    
    @FXML
    private void btnPrintAll(ActionEvent event){
        WorkWithXML.PrintAllFile(BusaWithInterface.URL);
        tableUsers.setItems(BusaWithInterface.oBooks);
        System.out.println("Printed!");
        
    }
    
    @FXML
    private void btnAddNew (ActionEvent event){
        WorkWithXML.AddInformation(BusaWithInterface.URL, authorFind.getText(), nameFind.getText(), typeFind.getText(), priceFind.getText(), dateFind.getText(), discrFind.getText());
        System.out.println("Added!");
        WorkWithXML.PrintAllFile(BusaWithInterface.URL);
        tableUsers.setItems(BusaWithInterface.oBooks);
        System.out.println("Printed!");
    }
    
    @FXML
    private void btnFindSth(ActionEvent event){
        WorkWithXML.FindInformation(BusaWithInterface.URL, findSth.getText());
        tableUsers.setItems(BusaWithInterface.oBooks);
        System.out.println("Found!");
    } 
    
}
