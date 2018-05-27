
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController implements Initializable {

    @FXML
    private TextField txtUsrName, txtPassword;
    
    @FXML
    private Label loginstatus;
   
    @FXML
    private Button btnSignin, btnExit;
    
    
   @FXML
    public void handleCloseButtonAction(ActionEvent event) {
    Stage stage = (Stage) btnExit.getScene().getWindow();
    stage.close();
}
   
       

    
   static String username;
    
   @FXML
    public void Login(ActionEvent event)throws IOException{
        username = txtUsrName.getText();
      
        if ( username.equals("admin") && txtPassword.getText().equals("admin")){
        	Parent MainMenupage = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
    		Scene MainMenuScene = new Scene(MainMenupage);
    		Stage MainMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		MainMenuStage.setScene(MainMenuScene);
           
        }
        else{
            loginstatus.setText("Login Failed");
        }
            
            
            
        }
    
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
 