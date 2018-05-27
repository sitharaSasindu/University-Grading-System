
package coursework02;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {
    @FXML 
    private Label lblGreeting;
    
    @FXML
    private Button inputDetails, viewMod, btnSignout;
    
   
    
    @FXML
    public void input(ActionEvent event)throws IOException{
    	Parent inputPage = FXMLLoader.load(getClass().getResource("Marksandreport.fxml"));
		Scene inputScene = new Scene(inputPage);
		Stage inputStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		inputStage.setScene(inputScene);
         
    }  
    
   
    
    
    @FXML
    public void viewModules(ActionEvent event)throws IOException{
    	 Parent root = FXMLLoader.load(getClass().getResource("moduleDetails.fxml"));
         Scene scene = new Scene(root);
         Stage stage = new Stage();
         //Stage stage= (Stage) (((Node) evt.getSource()).getScene().getWindow());
         stage.setTitle("Main Screen");
         stage.setScene(scene);
         stage.show();     
    }
    
    @FXML
    public void Signout(ActionEvent event)throws IOException{
    	Parent ReturnLoginPage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		Scene ReturnLoginScene = new Scene(ReturnLoginPage);
		Stage ReturnLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		ReturnLoginStage.setScene(ReturnLoginScene);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         lblGreeting.setText("Welcome, " + LoginPageController.username);
   
       
    
    }    
    
}
